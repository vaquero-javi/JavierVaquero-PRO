import model.Coche;
import model.Motor;

public class Entrada {
    public static void main(String[] args) {
        Coche coche = new Coche(new Motor(200,20),"1234A", "delantera");
        coche.mostrarDatos;
    }
}
