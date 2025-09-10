package model;

public class Elemento {
    private String id;
    private String titulo;
    private Persona autor;
    private int tamanio;
    private String formato;

    public Elemento(){}

    public Elemento(String id, String titulo, Persona autor, int tamanio, String formato){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this. tamanio = tamanio;
        this.formato= formato;
    }

    public void mostrarDatos(){
        System.out.println("El id es "+id);
        System.out.println("El titulo es "+titulo);
        System.out.println("El autor es "+autor.getNombre());
        System.out.println("El tamaño es "+tamanio);
        System.out.println("El formato es "+formato);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
