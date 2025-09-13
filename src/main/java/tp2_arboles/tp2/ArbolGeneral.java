package tp2_arboles.tp2;

import tp1_listas_enlazadas.ejercicio3.ColaGenerica;
import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;
import tp2_arboles.tp1.NodoGenerico;

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
		if (hijos == null)
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
		if (hijos == null)
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

	private void recorridoAuxiliarPre(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux) {

		if (arbol.esVacio()) {
			return;
		}
		listaAux.agregarFinal(arbol.getDato());
		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();    //---> SON LISTAS DE ARBOLES
		listaHijos.comenzar();
		while (!listaHijos.fin()) {
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

	private void recorridoAuxiliarIn(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux) {

		if (arbol.esVacio()) {
			return;
		}

		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
		listaHijos.comenzar();
		if (!listaHijos.esVacia()) {
			recorridoAuxiliarIn(listaHijos.proximo(), listaAux);
		}

		listaAux.agregarFinal(arbol.getDato());

		while (!listaHijos.fin()) {
			recorridoAuxiliarIn(listaHijos.proximo(), listaAux);    //mi no entender
		}
	}

	//recorrido de postorden -----------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> postOrden() {
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		this.recorridoAuxiliarPost(this, listaAux);
		return listaAux;
	}

	private void recorridoAuxiliarPost(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux) {

		if (arbol.esVacio()) {
			return;
		}

		ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
		listaHijos.comenzar();
		while (!listaHijos.fin() && !listaHijos.esVacia()) {
			recorridoAuxiliarPost(listaHijos.proximo(), listaAux);
		}
		listaAux.agregarFinal(arbol.getDato());
	}

	//Recorrido por niveles --------------------------------------------------------------------------------------------
	public ListaEnlazadaGenerica<T> niveles() {
		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<T> cola = new ColaGenerica<>();
		this.recorridoAuxiliarNiveles(this, listaAux, cola);
		return listaAux;
	}

	private void recorridoAuxiliarNiveles(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux, ColaGenerica<T> cola) {

		if (arbol.esVacio()) {
			return;
		}

		listaAux.agregarFinal(arbol.getDato());

		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
			listaHijos.comenzar();
			while (!listaHijos.fin()) {
				cola.encolar((T) listaHijos.proximo());
			}
		}

		while (!cola.esVacia()) {
			recorridoAuxiliarNiveles((ArbolGeneral<T>) cola.desencolar(), listaAux, cola);
		}
	}

	//------------------------------------------------------------------------------------------------------------------

	public Integer altura() {

		int niveles = 0;

		ListaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		this.listaValoresPorNivel(this, listaAux, cola);
		listaAux.comenzar();

		while(!listaAux.fin()){
			if (listaAux.proximo() == null) {
				niveles++;
			}
		}
		return niveles;
	}

	public Integer nivel(T dato) {

		int nivel = 0;

		ListaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		this.listaValoresPorNivel(this, listaAux, cola);
		listaAux.comenzar();

		while (!listaAux.fin()) {
			Integer leido = (Integer) listaAux.proximo();
			if(leido != null && leido == dato){
				break;
			}
			if(leido == null) {
				nivel++;
			}
		}
		return nivel;
	}

	public Integer ancho() {

		int ancho = 0;
		int contador = 0;

		ListaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		this.listaValoresPorNivel(this, listaAux, cola);
		listaAux.comenzar();

		while (!listaAux.fin()) {
			if (listaAux.proximo() == null) {
				if(ancho < contador){
					ancho = contador;
				}
				contador = 0;
			} else {
				contador++;
			}
		}
		return ancho;
	}

//----------------------------------------------------------------------------------------------------------------------
	public Boolean esAncestro(T a, T b) {

		ListaGenerica<ArbolGeneral<T>> listaNodos = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ArbolGeneral<T> nodoA = this.buscarNodo(this, a, listaNodos, cola);

		if (nodoA == null) return false;

		ListaEnlazadaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		this.recorridoAuxiliarPre(nodoA, listaAux);

		listaAux.comenzar();

		while (!listaAux.fin()) {
			if (listaAux.proximo().equals(b)) {
				return true;
			}
		}
		return false;
	}

	private ArbolGeneral<T> buscarNodo (ArbolGeneral<T> arbol, T a, ListaGenerica<ArbolGeneral<T>> listaNodos, ColaGenerica<ArbolGeneral<T>> cola) {
		if (arbol.esVacio()){
			return null;
		}
		if (arbol.getDato().equals(a)) {
			return arbol;
		}

		listaNodos.agregarFinal(arbol);

		if (arbol.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
			listaHijos.comenzar();
			while (!listaHijos.fin()) {
				cola.encolar(listaHijos.proximo());
			}
		}

		while (!cola.esVacia()) {
			ArbolGeneral<T> encontrado = buscarNodo(cola.desencolar(), a, listaNodos, cola);
			if (encontrado != null) {
				return encontrado;
			}
		}
		return null;
	}
//----------------------------------------------------------------------------------------------------------------------

	public Boolean esArbolLleno() {

		return false;
	}

	public Boolean esArbolCompleto() {
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(this.dato);
	}

	//------------------------------------------------------------------------------------------------------------------

	public double mayorPromedio() {

		ListaGenerica<T> listaAux = new ListaEnlazadaGenerica<>();
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		this.listaValoresPorNivel(this, listaAux, cola);

		listaAux.comenzar();

		double suma = 0;
		int iterador = 0;
		double mayor = 0;

		while (!listaAux.fin()) {

			//Double nodo = (Double) listaAux.proximo();
			Number nodo = (Number) listaAux.proximo();

			if (nodo == null) {
				double promedio = (suma / iterador);
				if (mayor < promedio) {
					mayor = promedio;
				}
				suma = 0;
				iterador = 0;
			} else {
				suma += nodo.doubleValue();
				//suma += nodo;
				iterador++;
			}
		}
		return mayor;
	}

	public void listaValoresPorNivel(ArbolGeneral<T> arbol, ListaGenerica<T> listaAux, ColaGenerica<ArbolGeneral<T>> cola) {

		if (arbol.esVacio()) {
			return;
		}
		cola.encolar(arbol);
		cola.encolar(null);

		while (!cola.esVacia()){
			ArbolGeneral<T> desencolado = cola.desencolar();

			if (desencolado == null){
				listaAux.agregarFinal(null);
				if (!cola.esVacia()) {		//sino agrega siempre el null del final a la cola porque todas las listas terminan en null
					cola.encolar(null);
				}

			} else {
				listaAux.agregarFinal(desencolado.getDato());
				if (desencolado.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> listaHijos = desencolado.getHijos();
					listaHijos.comenzar();
					while (!listaHijos.fin()){
						cola.encolar(listaHijos.proximo());
					}
				}
			}
		}
	}


	public void valoresHojas (ArbolGeneral<T> arbol, ListaGenerica<T> listaAux){

		if (arbol.esVacio()){
			return;
		}

		if (arbol.tieneHijos()){

			ListaGenerica<ArbolGeneral<T>> listaHijos = arbol.getHijos();
			listaHijos.comenzar();

			while (!listaHijos.fin()){
				valoresHojas(listaHijos.proximo(), listaAux);
			}

		} else {
			listaAux.agregarFinal(arbol.getDato());
		}
	}
}
