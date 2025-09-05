package tp1_listas_enlazadas.ejercicio3;

import tp1_listas_enlazadas.ListaGenerica.ListaEnlazadaGenerica;
import tp1_listas_enlazadas.ListaGenerica.ListaGenerica;

public class ColaGenerica<T> {

    private ListaGenerica<T> cola;              //me permite acceder a los metodos de la superclase sin extenderla

    public ColaGenerica() {
        this.cola = new ListaEnlazadaGenerica<T>();
    }

    public void encolar(T elem){
        this.cola.agregarFinal(elem);
    }

    public T desencolar (){

        if (this.cola.esVacia()){
            return null;
        }
        T desencolado = this.frente();
        //this.cola.eliminar(desencolado);      ---> si hay duplicados puede eliminar el incorrecto
        this.cola.eliminarEn(1);

        return desencolado;
    }

    public T frente (){
        if (this.cola.esVacia()){
            return null;
        }
        return this.cola.elemento(1);
    }

    public boolean esVacia(){
        return cola.esVacia();
    }


}
