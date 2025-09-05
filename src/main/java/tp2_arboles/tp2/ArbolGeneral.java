package tp2_arboles.tp2;

import tp1_listas_enlazadas.ejercicio3.ColaGenerica;
import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;
	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	//retorna el dato
	public T getDato() {
		return dato;
	}

	//setea el dato
	public void setDato(T dato) {
		this.dato = dato;
	}

	//setea los hijos
	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	//constructor
	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	//constructor con dato y lista de hijos
	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	//obtener los hijos como lista generica
	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	//agrega un nodo
	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	//pregunta si es hoja
	public boolean esHoja() {
		return !this.tieneHijos();
	}

	//pregunta si tiene hijos
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}

	//pregunta si es vacio
	public boolean esVacio() {
		return this.dato == null && !this.tieneHijos();
	}

	//eliminar un nodo
	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}

	//recorrido de preorden -----------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> preOrden() {
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		this.recorridoAuxiliarPre(this, listaAux);
		return listaAux;
	}

	private void recorridoAuxiliarPre(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux){

		if(arbol.esVacio()){
			return;
		}
		listaAux.agregarFinal(arbol.getDato());
		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();	//---> SON LISTAS DE ARBOLES
		listaHijos.comenzar();
		while (!listaHijos.fin()){
			recorridoAuxiliarPre(listaHijos.proximo(), listaAux);
		}
	}

	//recorrido de inorden -----------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> inOrden() {
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		this.recorridoAuxiliarIn(this, listaAux);
		return listaAux;
	}
//		  1
//	    / | \
//	   2  6  7
//	 / | \
//	3  4  5

	private void recorridoAuxiliarIn(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux){

		if(arbol.esVacio()){
			return;
		}

		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
		listaHijos.comenzar();
		if(!listaHijos.esVacia()){
			recorridoAuxiliarIn(listaHijos.proximo(), listaAux);
		}

		listaAux.agregarFinal(arbol.getDato());

		while (!listaHijos.fin()){
			recorridoAuxiliarIn(listaHijos.proximo(), listaAux);	//mi no entender
		}
	}


	//recorrido de postorden -----------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		this.recorridoAuxiliarPost(this, listaAux);
		return listaAux;
	}

	private void recorridoAuxiliarPost(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux){

		if(arbol.esVacio()){
			return;
		}

		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
		listaHijos.comenzar();
		while (!listaHijos.fin() && !listaHijos.esVacia()){
			recorridoAuxiliarPost(listaHijos.proximo(), listaAux);
		}
		listaAux.agregarFinal(arbol.getDato());
	}



	//Recorrido por niveles --------------------------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> niveles(){
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<T> cola = new ColaGenerica<>();
		this.recorridoAuxiliarNiveles(this, listaAux, cola);
		return listaAux;
	}

	private void recorridoAuxiliarNiveles(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux, ColaGenerica<T> cola){

		if(arbol.esVacio()){
			return;
		}

		listaAux.agregarFinal(arbol.getDato());

		if(arbol.tieneHijos()){
			ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
			listaHijos.comenzar();
			while(!listaHijos.fin()){
				cola.encolar((T) listaHijos.proximo());
			}
		}

		while (!cola.esVacia()){
			recorridoAuxiliarNiveles((ArbolGeneral<T>) cola.desencolar(), listaAux, cola);
		}
	}

	//------------------------------------------------------------------------------------------------------------------

	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

	@Override
	public String toString() {
		return String.valueOf(this.dato);
	}

}