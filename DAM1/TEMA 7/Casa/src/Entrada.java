import model.Terreno;
import util.Orientacion;
import controller.Constructora;
import util.ExcepcionConstruccion;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terreno terreno = null;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear terreno");
            System.out.println("2. Construir casa");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Metros cuadrados del terreno: ");
                        int metros = scanner.nextInt();
                        System.out.print("Orientación (NORTE, SUR, ESTE, OESTE): ");
                        Orientacion orientacion = Orientacion.valueOf(scanner.next().toUpperCase());
                        System.out.print("Valoración inicial: ");
                        double valoracion = scanner.nextDouble();
                        terreno = Constructora.crearTerreno(metros, orientacion, valoracion);
                        System.out.println("Terreno creado.");
                        break;
                    case 2:
                        if (terreno == null) {
                            System.out.println("Primero debes crear un terreno.");
                            break;
                        }
                        System.out.print("Metros cuadrados de la casa: ");
                        int metrosCasa = scanner.nextInt();
                        Constructora.construirCasa(terreno, metrosCasa);
                        System.out.println("Casa construida.");
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (ExcepcionConstruccion e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

