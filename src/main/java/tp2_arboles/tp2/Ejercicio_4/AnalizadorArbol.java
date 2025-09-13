package tp2_arboles.tp2.Ejercicio_4;

import tp1_listas_enlazadas.ejercicio3.ColaGenerica;
import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;
import tp2_arboles.tp2.ArbolGeneral;

public class AnalizadorArbol {

    public static int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol){

        ListaGenerica<AreaEmpresa> listaAux = new ListaEnlazadaGenerica<>();
        ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<>();
        arbol.listaValoresPorNivel(arbol, listaAux, cola);

        listaAux.comenzar();

        double suma = 0;
        int iterador = 0;
        double mayor = 0;

        while (!listaAux.fin()) {

            AreaEmpresa nodo = listaAux.proximo();

            if (nodo == null) {
                if (iterador > 0) {
                    double promedio = (suma / iterador);
                    if (mayor < promedio) {
                        mayor = promedio;
                    }
                }
                suma = 0;
                iterador = 0;
            } else {
                suma += nodo.tardanza();
                iterador++;
            }
        }
        return (int) mayor;
    }


}
