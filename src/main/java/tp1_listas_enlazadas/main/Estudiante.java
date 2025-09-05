package tp1_listas_enlazadas.main;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int legajo;

    public Estudiante(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + ", " + apellido +
                ", " + legajo;
    }
}
