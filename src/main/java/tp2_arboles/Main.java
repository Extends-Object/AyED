package tp2_arboles;

import tp2_arboles.tp2.ArbolGeneral;

public class Main {
    public static void main(String[] args) {

//      2.a) ¿Qué recorridos conoce para recorrer en profundidad un árbol general? Explique
//      brevemente.
//      En profundidad: recorrer los nodos siguiendo las ramas hasta el fondo antes de retroceder.
//      Principales recorridos en profundidad: preorden, postorden.

//      2.b) ¿Qué recorridos conoce para recorrer por niveles un árbol general? Explique
//      brevemente.
//      Principal recorrido en amplitud: recorrido por niveles.


//      2.c) ¿Existe alguna diferencia entre los recorridos preorden, postorden, inorden para
//      recorrer los árboles generales respecto de los árboles binarios?

//      En cuanto implementación, no es lo mismo implementar cualquiera de los tres
//      recorridos tanto para arboles generales como para arboles binarios. Porque el recorrido va a depender de la
//      estructura del arbol y de la implementacion del recorrido.
//      Si bien los arboles binarios son un caso especial de arboles generales, los recorridos a izquierda y derecha
//      funcionan solo en arboles binarios o binarios de busqueda, porque no hay forma de definir cual es el hijo
//      izquierdo, la raiz o el hijo derecho en cada caso. Se puede aplicar el recorrido manejando a los hijos como listas.

//      2.d) ¿Existe alguna noción de orden entre los elementos de un árbol general? Justifique
//      su respuesta.
//      No existe una noción de orden entre los elementos de un arbol general. No hay ninguna regla que especifique que
//      los valores se tienen que insertar en un orden especifico.
//
//      2.e) En un árbol general se define el grado de un nodo como el número de hijos de ese
//      nodo y el grado del árbol como el máximo de los grados de los nodos del árbol.
//      ¿Qué relación encuentra entre los Árboles Binarios sin tener en cuenta la
//      implementación? Justifique su respuesta.

//      En los arboles binarios, el mayor grado que tiene el arbol es grado 2, esto es, que puede tener como maximo
//      dos nodos hijos cada nodo.


        //hojas de 2
        ArbolGeneral<Integer> hoja5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> hoja6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> hoja7 = new ArbolGeneral<>(7);

        //hojas de 1
        ArbolGeneral<Integer> hoja3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> hoja4 = new ArbolGeneral<>(4);


        ArbolGeneral<Integer> nodo2 = new ArbolGeneral<>(2);
        nodo2.agregarHijo(hoja5);
        nodo2.agregarHijo(hoja6);
        nodo2.agregarHijo(hoja7);

        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(1);
        raiz.agregarHijo(nodo2);
        raiz.agregarHijo(hoja3);
        raiz.agregarHijo(hoja4);

//        System.out.println("INORDEN: " + raiz.inOrden());
//        System.out.println("PREORDEN: " + raiz.preOrden());
//        System.out.println("POSTORDEN: " + raiz.postOrden());
//
//        System.out.println("\n");
//
//        System.out.println("Impares mayores que 2: " + RecorridosAG.numerosImparesMayoresQuePreOrden(raiz, 2));
//        System.out.println("Impares mayores que 3: " + RecorridosAG.numerosImparesMayoresQueInOrden(raiz, 3));
//        System.out.println("Impares mayores que 1: " + RecorridosAG.numerosImparesMayoresQuePostOrden(raiz, 1));


        System.out.println("NIVELES: " + raiz.niveles());

        System.out.println("Impares mayores que 4: " + RecorridosAG.numerosImparesMayoresQuePorNiveles(raiz, 4));




    }
}
