package model;

public class Libro extends Elemento{
    private String isbn;
    private  int numPaginas;

    public Libro(){}

    public Libro(String isbn, int numPaginas){
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    public Libro(String id, String titulo, Persona autor, int tamanio, String formato, String isbn, int numPaginas) {
        super(id, titulo, autor, tamanio, formato);
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
