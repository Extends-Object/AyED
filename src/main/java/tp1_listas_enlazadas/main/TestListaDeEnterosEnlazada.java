package tp1_listas_enlazadas.main;

import tp1_listas_enlazadas.ListaEnteros.ListaDeEnteros;
import tp1_listas_enlazadas.ListaEnteros.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {
    public static void main(String[] args) {

//      1.3 Escriba una clase llamada TestListaDeEnterosEnlazada que reciba en su metodo main una secuencia de números,
//      los agregue a un objeto de tipo ListaDeEnterosEnlazada y luego imprima los elementos de dicha lista.

        ListaDeEnteros listaEnlazada = new ListaDeEnterosEnlazada();

        listaEnlazada.agregarFinal(3);
        listaEnlazada.agregarFinal(5);
        listaEnlazada.agregarFinal(7);

        while (!listaEnlazada.fin()){
            System.out.println(listaEnlazada.proximo());
        }

//      1.4 ¿Qué diferencia encuentra entre las implementaciones de los puntos anteriores?
//      Arrays:
//        - Representacion interna: la lista se guarda en bloques continuos de memoria.
//        - Se puede acceder con indice
//        - Insersiones/ eliminaciones:
//                Insertar/eliminar al final: O(1) amortizado (salvo redimensionar).
//                Insertar/eliminar en el medio o al inicio: O(n) (hay que desplazar elementos).
//        - Uso de memoria: guarda los datos sin overhead adicional. Desaprovechamiento de espacio.
//      Listas:
//        - Representacion interna: la lista se guarda como una cadena de nodos
//        - Los nodos distribuidos en la memoria y enlazados
//                Insertar/eliminar al inicio: O(1).
//                Insertar/eliminar en el medio: O(n) (recorrer hasta la posición).
//                Insertar con un puntero ya posicionado: O(1).
//        - Uso de memoria: cada nodo con espacio extra para la referencia siguiente (y el anterior si es doble).
//          No desperdicia espacio contiguo pero si tiene overhead.

        listaEnlazada.comenzar();
        listaEnlazada.imprimirRecursivo(listaEnlazada);
    }
}
