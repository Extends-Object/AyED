package tp1_listas_enlazadas.main;

import tp1_listas_enlazadas.ListaGenerica.ListaArrayGenerica;
import tp1_listas_enlazadas.ListaGenerica.ListaEnlazadaGenerica;
import tp1_listas_enlazadas.ListaGenerica.ListaGenerica;

public class Punto1_listas_genericas {
    public static void main(String[] args) {

        //todas las wrappers tienen su toString implementado

        ListaGenerica<Integer> array = new ListaArrayGenerica<Integer>(5);

        array.agregarFinal(4);
        array.agregarFinal(7);
        array.agregarFinal(10);
        array.agregarFinal(2);

        array.imprimirIterativo();
        System.out.println("\n");

        array.comenzar();
        array.imprimirRecursivo();
        System.out.println("\n");

//----------------------------------------------------------------------------------------------------------------------

        ListaGenerica listaEnlazada = new ListaEnlazadaGenerica<Integer>();

        listaEnlazada.agregarFinal(65);
        listaEnlazada.agregarFinal(34);
        listaEnlazada.agregarFinal(72);
        listaEnlazada.agregarFinal(52);

        listaEnlazada.comenzar();
        listaEnlazada.imprimirIterativo();
        System.out.println("\n");

        listaEnlazada.comenzar();
        listaEnlazada.imprimirRecursivo();
        System.out.println("\n");

    }
}
