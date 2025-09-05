package tp1_listas_enlazadas.ListaGenerica;

public class ListaArrayGenerica<T> extends ListaGenerica<T> {

    private int tamanio;        //dLogica
    private T[] datos;
    private int actual = 0;             //pos - 1 en esta implementacion
    private int dFisica;

    //Constructorrr
    public ListaArrayGenerica(int dFisica) {
        datos = (T[]) new Object[dFisica];         //no se puede hacer new de un generico entonces crea un object y lo castea
        this.dFisica = dFisica;
    }
    //Java no puede comprobar en tiempo de compilación que el cast es
    //seguro y da un warning de unchecked cast

    @Override
    public void comenzar() {
        actual = 0;
    }

    @Override
    public T proximo() {
        return datos[actual++];
    }

    @Override
    public boolean fin() {
        return (actual == tamanio);
    }

    @Override
    public T elemento(int pos) {
        return datos[pos - 1];
    }

    @Override
    public boolean agregarEn(T elem, int pos) {
        if (pos < 1 || pos > tamanio + 1 || pos > datos.length
                || tamanio == datos.length)
            return false;
        tamanio++;
        for (int i = tamanio - 1; i >= pos; i--)
            datos[i] = datos[i - 1];
        datos[pos - 1] = elem;
        return true;
    }

    @Override
    public boolean agregarInicio(T elem) {
        return this.agregarEn(elem, 1);
    }

    @Override
    public boolean agregarFinal(T elem) {
        if (tamanio == dFisica) {
            return false;
        }
        tamanio++;
        datos[tamanio-1] = elem;
        return true;
    }

    @Override
    public boolean eliminar(T elem) {
        boolean encontre = false;
        int i = 0;
        while (i < tamanio && !encontre) {
            if (datos[i].equals(elem)) {
                eliminarEn(i+1);            //maneja el indice empezando en 1, por eso pasa pos+1
                encontre = true;
            }
            i++;
        }
        return encontre;
    }

    @Override
    public boolean eliminarEn(int pos) {
        if (pos < 1 || pos > tamanio)
            return false;
        tamanio--;
        for (int i = pos - 1; i < tamanio; i++){
            datos[i] = datos[i + 1];}
        return true;
    }

    @Override
    public boolean incluye(T elem) {
        int i = 0;
        while (i < tamanio){
            if (datos[i].equals(elem)){
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public boolean reemplazarEn(T elem, int pos) {
        if (elem == null || pos > tamanio){
            return false;
        }
        datos[pos-1] = elem;         //pos puede ser 0 en la estructura, pero tiene que ser minimo 1 por implememtacion
        return true;
    }

//    @Override
//    public ListaGenerica<T> clonar() {                      //se puede hacer que sea generico
//
//        ListaArrayGenerica<T> arrayClon = new ListaArrayGenerica<T>(this.dFisica);
//
//        for (int i = 0; i < tamanio; i++){
//            arrayClon.agregarFinal(this.datos[i]);
//        }
//        return arrayClon;
//    }

    @Override
    public ListaGenerica<T> crearVacia() {
        ListaGenerica <T> nueva = new ListaArrayGenerica<T>(this.dFisica);
        return nueva;
    }
}
