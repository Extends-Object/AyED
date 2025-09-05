package tp2_arboles;

import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;
import tp2_arboles.tp2.ArbolGeneral;

import java.util.function.Function;

public class RecorridosAG {

//---------------------- comportamiento empaquetadou

    private static ListaGenerica<Integer> numerosImparesMayoresQue(
            ArbolGeneral<Integer> a, Integer n, Function<ArbolGeneral<Integer>, ListaGenerica<Integer>> recorridoElegido){

        ListaGenerica<Integer> imparesMayoresA = new ListaEnlazadaGenerica<Integer>();
        ListaGenerica<Integer> listaAux = recorridoElegido.apply(a);
        listaAux.comenzar();

        while (!listaAux.fin()) {
            Integer valor = listaAux.proximo();
            if (valor % 2 != 0 && valor > n) {
                imparesMayoresA.agregarFinal(valor);
            }
        }
        return imparesMayoresA;
    }


    public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
        return numerosImparesMayoresQue(a, n, ArbolGeneral::preOrden);
    }

    public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n){
        return numerosImparesMayoresQue(a, n, ArbolGeneral::inOrden);
    }

    public static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
        return numerosImparesMayoresQue(a, n, ArbolGeneral::postOrden);
    }

    public static ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n){
        return numerosImparesMayoresQue(a, n, ArbolGeneral::niveles);
    }



//----------------------------------------------------------------------------------------------------------------------
//    public static ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n) {
//
//        ListaGenerica<Integer> imparesMayoresA = new ListaEnlazadaGenerica<Integer>();
//        ListaGenerica<Integer> listaAux = a.preOrden();     //empaquetar comportamiento
//        listaAux.comenzar();
//
//        while (!listaAux.fin()) {
//            Integer valor = listaAux.proximo();
//            if (valor % 2 != 0 && valor > n) {
//                imparesMayoresA.agregarFinal(valor);
//            }
//        }
//        return imparesMayoresA;
//    }
//
//    public static ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, Integer n) {
//
//        ListaGenerica<Integer> imparesMayoresA = new ListaEnlazadaGenerica<Integer>();
//        ListaGenerica<Integer> listaAux = a.inOrden();     //empaquetar comportamiento
//        listaAux.comenzar();
//
//        while (!listaAux.fin()) {
//            Integer valor = listaAux.proximo();
//            if (valor % 2 != 0 && valor > n) {
//                imparesMayoresA.agregarFinal(valor);
//            }
//        }
//        return imparesMayoresA;
//    }
//
//    public static ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n) {
//        ListaGenerica<Integer> imparesMayoresA = new ListaEnlazadaGenerica<Integer>();
//        ListaGenerica<Integer> listaAux = a.inOrden();     //empaquetar comportamiento
//        listaAux.comenzar();
//
//        while (!listaAux.fin()) {
//            Integer valor = listaAux.proximo();
//            if (valor % 2 != 0 && valor > n) {
//                imparesMayoresA.agregarFinal(valor);
//            }
//        }
//        return imparesMayoresA;
//    }
//
//    public static ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral<Integer> a, Integer n) {
//        ListaGenerica<Integer> imparesMayoresA = new ListaEnlazadaGenerica<Integer>();
//        ListaGenerica<Integer> listaAux = a.recorridoNiveles();
//        listaAux.comenzar();
//
//        while (!listaAux.fin()) {
//            Integer valor = listaAux.proximo();
//            if (valor % 2 != 0 && valor > n) {
//                imparesMayoresA.agregarFinal(valor);
//            }
//        }
//        return imparesMayoresA;
//    }

//----------------------------------------------------------------------------------------------------------------------

}
