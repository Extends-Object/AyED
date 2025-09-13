package tp2_arboles;

import tp1_listas_enlazadas.ejercicio3.ColaGenerica;
import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;
import tp2_arboles.tp2.ArbolGeneral;
import tp2_arboles.tp2.Ejercicio_4.AnalizadorArbol;
import tp2_arboles.tp2.Ejercicio_4.AreaEmpresa;
import tp2_arboles.tp2.Ejercicio_5.RedDeAguaPotable;
import tp2_arboles.tp2.RecorridosAG;

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

        //hojas de 4
        ArbolGeneral<Integer> hoja8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> hoja9 = new ArbolGeneral<>(9);

        //hoja de 7
        ArbolGeneral<Integer> hoja10 = new ArbolGeneral<>(10);

        //hojas de 1
        ArbolGeneral<Integer> hoja3 = new ArbolGeneral<>(3);


        ArbolGeneral<Integer> nodo4 = new ArbolGeneral<>(4);
        nodo4.agregarHijo(hoja8);
        nodo4.agregarHijo(hoja9);

        ArbolGeneral<Integer> nodo7 = new ArbolGeneral<>(7);
        nodo7.agregarHijo(hoja10);


        ArbolGeneral<Integer> nodo2 = new ArbolGeneral<>(2);
        nodo2.agregarHijo(hoja5);
        nodo2.agregarHijo(hoja6);
        nodo2.agregarHijo(nodo7);

        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(1);
        raiz.agregarHijo(nodo2);
        raiz.agregarHijo(hoja3);
        raiz.agregarHijo(nodo4);

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


//        Si ahora tuviera que implementar estos métodos en la clase ArbolGeneral <T>,
//        ¿qué modificaciones haría tanto en la firma como en la implementación de los mismos?
//        - Deja de recibir el arbol como parametro
//        - Moveria la logica de los recorridos pero mantendria separada la logica de "menores que"


        System.out.println("\n");

        System.out.println("PRUEBA PROMEDIO: " + raiz.mayorPromedio());

        System.out.println("--------------------------------------------------------------------------------------\n");

        ListaGenerica<Integer> listaAux = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        raiz.listaValoresPorNivel(raiz, listaAux, cola);
        System.out.println(listaAux);

        System.out.println("--------------------------------------------------------------------------------------\n");

        //EJERCICIO 4

        ArbolGeneral<AreaEmpresa> area10 = new ArbolGeneral<>(new AreaEmpresa("Area 10", 10));

        ArbolGeneral<AreaEmpresa> area2 = new ArbolGeneral<>(new AreaEmpresa("Area 2", 3));
        ArbolGeneral<AreaEmpresa> area4 = new ArbolGeneral<>(new AreaEmpresa("Area 4", 15));
        ArbolGeneral<AreaEmpresa> area9 = new ArbolGeneral<>(new AreaEmpresa("Area 9", 35));

        area10.agregarHijo(area2);
        area10.agregarHijo(area4);
        area10.agregarHijo(area9);

        ArbolGeneral<AreaEmpresa> area15 = new ArbolGeneral<>(new AreaEmpresa("Area 15", 13));

        area4.agregarHijo(area15);

        System.out.println("Mayor promedio de todas las areas: " + AnalizadorArbol.devolverMaximoPromedio(area10));

        System.out.println("\n");
//----------------------------------------------------------------------------------------------------------------------
        ArbolGeneral<Double> maestro = new ArbolGeneral<>(0.0);

        ArbolGeneral<Double> caño2 = new ArbolGeneral<>(0.0);
        ArbolGeneral<Double> caño3 = new ArbolGeneral<>(0.0);
        ArbolGeneral<Double> caño4 = new ArbolGeneral<>(0.0);
        ArbolGeneral<Double> caño5 = new ArbolGeneral<>(0.0);

        maestro.agregarHijo(caño2);
        maestro.agregarHijo(caño3);
        maestro.agregarHijo(caño4);
        maestro.agregarHijo(caño5);

        caño3.agregarHijo(new ArbolGeneral<>(0.0));
        ArbolGeneral<Double> caño7 = new ArbolGeneral<>(0.0);
        caño3.agregarHijo(caño7);


        caño4.agregarHijo(new ArbolGeneral<>(0.0));
        caño4.agregarHijo(new ArbolGeneral<>(0.0));
        ArbolGeneral<Double> caño10 = new ArbolGeneral<>(0.0);
        caño4.agregarHijo(caño10);
        caño4.agregarHijo(new ArbolGeneral<>(0.0));
        caño4.agregarHijo(new ArbolGeneral<>(0.0));

        caño7.agregarHijo(new ArbolGeneral<>(0.0));
        caño10.agregarHijo(new ArbolGeneral<>(0.0));
        caño10.agregarHijo(new ArbolGeneral<>(0.0));

        RedDeAguaPotable red = new RedDeAguaPotable(maestro);

        double minimo = red.minimoCaudal(1000.0);
        System.out.println("Caudal mínimo recibido por una casa: " + minimo);

        System.out.println("--------------------------------------------------------------------------------------\n");

        //hojas de 2
        ArbolGeneral<Integer> h5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> h6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> h7 = new ArbolGeneral<>(7);

        ArbolGeneral<Integer> n8 = new ArbolGeneral<>(8);

        ArbolGeneral<Integer> h9 = new ArbolGeneral<>(9);

        ArbolGeneral<Integer> n3 = new ArbolGeneral<>(3);

        ArbolGeneral<Integer> n4 = new ArbolGeneral<>(4);
        n4.agregarHijo(n8);
        n8.agregarHijo(h9);

        n3.agregarHijo(h7);

        ArbolGeneral<Integer> n2 = new ArbolGeneral<>(2);
        n2.agregarHijo(h5);
        n2.agregarHijo(h6);

        ArbolGeneral<Integer> n1 = new ArbolGeneral<>(1);
        n1.agregarHijo(n2);
        n1.agregarHijo(n3);
        n1.agregarHijo(n4);

        System.out.println("Altura de este arbol: " + n1.altura());
        System.out.println("Nivel de este dato (3): este dato esta en el nivel " + n1.nivel(3) + " de profundidad.");
        System.out.println("Nivel de este dato (1):  este dato esta en el nivel " + n1.nivel(1) + " de profundidad.");
        System.out.println("Nivel de este dato (9):  este dato esta en el nivel " + n1.nivel(9) + " de profundidad.");
        System.out.println("\n");
        System.out.println("El ancho de este arbol es: " + n1.ancho());







    }
}
