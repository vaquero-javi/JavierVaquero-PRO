import controller.Hotel;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        System.out.println("Introduce el nombre, apellido, telefono y dni");
        if (hotel.registrarReserva(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextLine(), scanner.nextInt()))
        {
            System.out.println("Usuario agregado correctamente");
        }else{
            System.out.println("Usuario ya registrado");
        }
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Mostrar reservas actuales");
            System.out.println("4. Mostrar reservas ordenadas");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Número de habitación: ");
                    int numHabitacion = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    System.out.print("Nombre del huésped: ");
                    String nombreHuesped = scanner.nextLine();
                    System.out.print("Teléfono del huésped: ");
                    String telefono = scanner.nextLine();
                    System.out.print("DNI del huésped: ");
                    String dni = scanner.nextLine();
                    System.out.print("Número de personas: ");
                    int numPersonas = scanner.nextInt();
                    hotel.registrarReserva(numHabitacion, nombreHuesped, telefono, dni, numPersonas);
                    break;

                case 2:
                    System.out.print("Introduce el DNI del huésped para cancelar su reserva: ");
                    String dniCancelar = scanner.nextLine();
                    hotel.cancelarReserva(dniCancelar);
                    break;

                case 3:
                    hotel.mostrarReservas();
                    break;

                case 4:
                    hotel.mostrarReservasOrdenadas();
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema de reservas, nos vemos pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

}


