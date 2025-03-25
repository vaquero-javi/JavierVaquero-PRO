import controller.Centro;
import model.Doctor;
import model.Paciente;
import util.TipoGeneral;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//No entiendo la linea 61 de Entrada.
//No entiendo la 61 de Centro

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Centro centro = new Centro();

        int opcion = 0;
        do {
            System.out.println("1. Admitir paciente");
            System.out.println("2. Contratar doctor");
            System.out.println("3. Ver doctores");
            System.out.println("4. Ver pacientes");
            System.out.println("5. Pedir cita");
            System.out.println("6. Salir");
            opcion= scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("NSS: ");
                    String nss = scanner.nextLine();
                    System.out.print("Dolencia: ");
                    String dolencia = scanner.nextLine();
                    centro.admitirPaciente(new Paciente());
                    break;
                case 2:
                    System.out.print("Nombre Doctor: ");
                    String nombreDoc = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoDoc = scanner.nextLine();
                    System.out.print("Número Colegiado: ");
                    String numColegiado = scanner.nextLine();
                    centro.contratarDoctor(new Doctor());
                    break;
                case 3:
                    centro.getListaDoctores();
                    break;
                case 4:
                    centro.getListaPacientes();
                    break;
                case 5:
                    System.out.print("NSS del paciente: ");
                    String nssPaciente = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = scanner.nextLine();
                    centro.pedirCita(nssPaciente, especialidad, fecha);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

    }
}
