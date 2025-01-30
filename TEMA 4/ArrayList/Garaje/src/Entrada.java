import java.util.Scanner;

public class Entrada {

    //VISTA
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        Garaje garaje2 = new Garaje();
        System.out.println("Bienvenido a la app de gestión de coches");
        garaje.anadirCoche("Mercedes","c220",120,"1234A");
        garaje.anadirCoche("Ford","Fiesta",100,"1234B");
        garaje.mostarCoches();


        garaje2.mostarCoches();


    }
}
