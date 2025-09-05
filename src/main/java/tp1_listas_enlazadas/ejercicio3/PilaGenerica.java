package tp1_listas_enlazadas.ejercicio3;

import tp1_listas_enlazadas.ListaGenerica.ListaEnlazadaGenerica;
import tp1_listas_enlazadas.ListaGenerica.ListaGenerica;

public class PilaGenerica<T> {

    private ListaGenerica<T> pila;

    public PilaGenerica() {
        this.pila = new ListaEnlazadaGenerica<T>();
    }

    public void apilar(T elem){
        this.pila.agregarInicio(elem);
    }

    public T desapilar (){
        
        if (this.pila.esVacia()){
            return null;
        }
        T desapilado = this.pila.elemento(1);
        this.pila.eliminarEn(1);

        return desapilado;
    }

    public T tope (){
        if (this.pila.esVacia()){
            return null;
        }
        return this.pila.elemento(0);
    }

    public boolean esVacia(){
        return this.pila.esVacia();
    }
}
