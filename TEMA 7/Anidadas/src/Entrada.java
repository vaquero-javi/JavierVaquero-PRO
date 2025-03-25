import model.ClasePadre;

public class Entrada {
    public static void main(String[] args) {
        ClasePadre clasePadre = new ClasePadre();
        clasePadre.mostrarDatos();

        ClasePadre.ClaseHija claseHija= clasePadre.new ClaseHija();

    }
}
