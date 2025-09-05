package tp1_listas_enlazadas.main;

import tp1_listas_enlazadas.ListaEnteros.ListaDeEnteros;
import tp1_listas_enlazadas.ListaEnteros.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {
    public static void main(String[] args) {

//        1.2 Escriba una clase llamada TestListaDeEnterosConArreglos que reciba en su
//        metodo main una secuencia de números, los agregue a un objeto de tipo
//        ListaDeEnterosConArreglos y luego imprima los elementos de dicha lista.

        Integer [] numeros = {1, 2, 5, 9, 4, 12, 54, 8};

        ListaDeEnteros array = new ListaDeEnterosConArreglos();

        for (int i = 0; i < numeros.length; i++) {
            array.agregarFinal(numeros[i]);
        }

        while (!array.fin()){
            System.out.println(array.proximo());
        }
    }
}
