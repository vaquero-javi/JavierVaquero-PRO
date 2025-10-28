import model.Armas;
import model.Humanos;
import model.Superheroe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Superheroe> superheroes = new ArrayList<>();


        int opcion = 0;
        do {
            System.out.println("===================================");
            System.out.println("MENÚ SUPERHEROES");
            System.out.println("===================================");
            System.out.println("1.Crear superheroes");
            System.out.println("2.Listar superheroes");
            System.out.println("3.Listar armas");
            System.out.println("4.Enfrentar superheroes");
            System.out.println("===================================");
            System.out.println("Introduce el numero que quieras hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Nivel: ");
                    int nivel = scanner.nextInt();
                    System.out.println("Nivel Superheroe: ");
                    int nivelSuperheroe = scanner.nextInt();
                    System.out.println("Nombre: ");
                    String nombre = scanner.next();
                    System.out.println("Nivel: ");
                    Armas armas = new Armas();
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

            }
        } while (opcion!=5);

    }
}