import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        CampeonatoFormula1 campeonato = new CampeonatoFormula1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar piloto");
            System.out.println("2. Actualizar puntos de una carrera");
            System.out.println("3. Mostrar información de un piloto");
            System.out.println("4. Mostrar clasificación");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nombre del piloto:");
                    String nombre = scanner.nextLine();
                    System.out.println("Introduzca el bastidor del coche:");
                    String bastidor = scanner.nextLine();
                    campeonato.agregarPiloto(nombre, bastidor);
                    break;
                case 2:
                    campeonato.actualizarPuntosCarrera();
                    break;
                case 3:
                    System.out.println("Introduzca el bastidor del piloto:");
                    bastidor = scanner.nextLine();
                    campeonato.mostrarInformacionPiloto(bastidor);
                    break;
                case 4:
                    campeonato.mostrarClasificacion();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Error, opción no válida.");
                    break;
            }
        }
    }
}

