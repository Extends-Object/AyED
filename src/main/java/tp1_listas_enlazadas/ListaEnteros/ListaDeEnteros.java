package tp1_listas_enlazadas.ListaEnteros;

public abstract class ListaDeEnteros {
	
	public abstract void comenzar();
	public abstract Integer proximo();
	public abstract boolean fin();
	
	public abstract Integer elemento(int pos);
	
	public abstract boolean agregarEn(Integer elem, int pos);
	public abstract boolean agregarInicio(Integer elem);
	public abstract boolean agregarFinal(Integer elem);
	
	public abstract boolean eliminar(Integer elem);
	public abstract boolean eliminarEn(int pos);
	
	public abstract boolean incluye(Integer elem);
	public abstract boolean esVacia();
	public abstract int tamanio();

//	Escriba un metodo recursivo que imprima los elementos de una lista en sentido inverso. La lista la recibe por parámetro.
	public abstract void imprimirRecursivo (ListaDeEnteros lista);


//	1.6.a) ¿Podría darle comportamiento a algún metodo de la superclase
//	ListaDeEnteros? ¿Por qué la clase se define como abstracta? Note que una
//	subclase implementa la lista usando un arreglo de tamaño fijo y la otra
//	usando nodos enlazados.
//
//	Se le puede dar comportamiento a la superclase a los siguientes casos:
//	- Cuando el comportamiento es comun a todas las subclases: es decir, todos responden igual
//		se puede definir en la superclase.
//	- Cuando el comportamiento puede implementarse de forma generica. Todas las subclases comparten la lógica.
//	- Cuando se quiere dar una implementación por defecto que las subclases pueden heredar o sobrescribir, asi la
//		superclase da un "comportamiento base" que puede ser extendido.
//	- Para evitar duplicacion de codigo, si varias subclases implementan lo mismo se puede poner en la superclase.
//	- Cuando la superclase no es abstracta y se instancia.
//
//		Darle comportamiento a una superclase conviene cuando hay comportamiento común,
//		genérico, o reutilizable que todas (o casi todas) las subclases pueden heredar o extender.
//		Si el comportamiento depende sí o sí de cada subclase, ahí la superclase solo define el
//		qué (metodo abstracto), no el cómo.
//
//	1.6.b) Considerando los enlaces entre nodos, ¿qué diferencias existen entre
//	agregar un nodo al principio de la lista, agregar un nodo en el medio y
//	agregar un nodo al final?
//
//	Las diferencias que hay son:
//	Listas:
//	- Agregar al principio: no hay esfuerzo, se apunta el primero como la cabeza y se reacomodan los punteros
//			quedando el que era la cabeza como el segundo nodo de la lista.
//	- Agregar al medio: recorrer hasta en contrar la posicion deseada, insertar anidando la cola de la lista primero,
//		acomodar puntero anterior al insertado (que ahora es el actual).
//	- Agregar al final: insertar al final apuntando al nuevo nodo y este a null.
//
//	Arrays:
//	- Agregar al principio: si hay dimension fisica disponible, conlleva reacomodamiento.
//	- Agregar en el medio: si hay dimension fisica disponible, conlleva reacomodamiento.
//	- Agregar al final: si hay dimension fisica disponible, se agrega al final.
//
//
//	1.6.c) Una lista implementada con arreglos, ¿tiene su primer elemento en el
//	índice del vector: 0, 1 o depende de la implementación?
//
//	Depende de la implementacion. Puedo tener un modulo que acceda a los datos retornando desde la posicion - 1, por
//	lo que al pedir el primer valor desde la posicion 1 como "primera posicion", estaria retornando el de la posicion
//	- 1, es decir, 1 - 1 = 0.
//
//
}
