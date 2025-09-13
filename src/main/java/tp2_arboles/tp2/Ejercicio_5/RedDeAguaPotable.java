package tp2_arboles.tp2.Ejercicio_5;

import tp2_arboles.tp1.ListaEnlazadaGenerica;
import tp2_arboles.tp1.ListaGenerica;
import tp2_arboles.tp2.ArbolGeneral;

public class RedDeAguaPotable {

    private ArbolGeneral<Double> red;

    public RedDeAguaPotable(ArbolGeneral<Double> red) {
        this.red = red;
    }

    public double minimoCaudal(double caudal){

        this.dividirCaudal(red, caudal);

        ListaGenerica<Double> listaCasas = new ListaEnlazadaGenerica<>();
        this.red.valoresHojas(this.red, listaCasas);
        listaCasas.comenzar();

        double menor = caudal;

        while (!listaCasas.fin()){
            Double caudalCasa = listaCasas.proximo().doubleValue();
            if(caudalCasa < menor) {
                menor = caudalCasa;
            }
        }

        return menor;
    }

    private void dividirCaudal (ArbolGeneral<Double> caño, double caudal) {

        if (caño.esVacio()){
            return;
        }

        caño.setDato(caudal);

        if (caño.tieneHijos()){
            ListaGenerica<ArbolGeneral<Double>> listaCaños = caño.getHijos();
            listaCaños.comenzar();

            caudal = (caudal/listaCaños.tamanio());

            while (!listaCaños.fin()){
                dividirCaudal(listaCaños.proximo(), caudal);
            }
        }
    }


}
