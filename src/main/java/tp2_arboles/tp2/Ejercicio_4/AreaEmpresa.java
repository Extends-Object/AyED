package tp2_arboles.tp2.Ejercicio_4;

public class AreaEmpresa {

    private String identificacion;
    private int tardanza;

    public AreaEmpresa(String identificacion, int tardanza) {
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }

    public AreaEmpresa() {
        this.identificacion = "";
        this.tardanza = 0;
    }

    public String identificacion() {
        return identificacion;
    }

    public int tardanza() {
        return tardanza;
    }

    @Override
    public String toString() {
        return String.valueOf(tardanza);
    }
}
