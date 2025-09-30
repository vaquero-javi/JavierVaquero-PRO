package model;

//Un encargo debe tener un responsable

public class Encargo {

    private int id;
    private String descripcion;
    private boolean completada;

    public Encargo() {
    }

    public Encargo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public void mostrarDatos(){
        System.out.println("id = " + id);
        System.out.println("descripcion = " + descripcion);
        System.out.println("completada = " + completada);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Encargo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                '}';
    }
}
