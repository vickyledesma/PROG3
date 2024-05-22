import java.util.ArrayList;

public class Tarea<T> extends Vertice<String> {
    private String nombre;
    private String descripcion;
    private int duracion;

    public Tarea(int verticeId, ArrayList<Arco<String>> adyacentes,String nombre, String descripcion, int duracion) {
        super(verticeId, adyacentes);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }
}