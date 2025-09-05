package tp1_listas_enlazadas.main;

import tp1_listas_enlazadas.ListaGenerica.ListaEnlazadaGenerica;
import tp1_listas_enlazadas.ListaGenerica.ListaGenerica;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {

//        Escriba una clase llamada TestListaEnlazadaGenerica que cree 4 objetos de
//        tipo Estudiante (con apellido, nombre, legajo) y los agregue a un objeto de tipo
//        ListaEnlazadaGenerica usando los diferentes métodos de la lista y luego, imprima
//        los elementos de dicha lista usando el metodo tusDatos().
//
        Estudiante e1 = new Estudiante("Pepito", "Perez", 123);
        Estudiante e2 = new Estudiante("Fulanito", "Gomez", 456);
        Estudiante e3 = new Estudiante("Menganito", "Suarez", 789);
        Estudiante e4 = new Estudiante("Perico", "Ramirez", 159);

        ListaGenerica<Estudiante> listaEstudiantes = new ListaEnlazadaGenerica<Estudiante>();

        listaEstudiantes.agregarFinal(e1);
        listaEstudiantes.agregarFinal(e2);
        listaEstudiantes.agregarFinal(e3);
        listaEstudiantes.agregarFinal(e4);
        listaEstudiantes.agregarEn(e4, 1);

        listaEstudiantes.tusDatos();

//      2.4.a) Qué diferencia observa entre las implementaciones de ListaEnlazadaGenerica y ListaDeEnterosEnlazada?
//
//        La diferencia entre la lista generica y la enlazada comun:
//        - Lista generica: usa tipado genérico, el tipo T se define al momento de instanciar la clase.
//              Permite que la misma implementación maneje cualquier tipo.

//        - Lista enlazada comun: es tipada explicitamente a un tipo definido. Su tipo esta fijo en la definicion de la
//              clase.

//      2.4.b) Cómo se define el nodo genérico? ¿Cómo se crea una instancia del mismo?
//
//        Los nodos tambien se definen genericamente y se les indica el tipo de dato en la instancia del nodo.
//
//      2.4.c) Qué devuelve el metodo elemento() de la lista?
//
//        Devuelve el elemento que se encuentra en la (posicion - 1) que se le consulta.
//
//

    }
}
