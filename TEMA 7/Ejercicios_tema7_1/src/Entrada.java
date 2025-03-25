import utils.LetraException;
import utils.LongitudException;

import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Formulario formulario = new Formulario();

        int opcion;
        System.out.println("Introduce la opcion que quieras");
        do {
            System.out.println("1. Rellenar nombre.");
            System.out.println("2. Rellenar apellidos.");
            System.out.println("3. Rellenar DNI.");
            System.out.println("4. Finalizar.");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce tu nombre");
                    String nombre = scanner.next();
                    formulario.setNombre(nombre);
                    break;
                case 2:
                    System.out.println("Introduce tus apellidos");
                    String apellidos = scanner.nextLine();
                    formulario.setApellido(apellidos);
                    break;

                try {
                    formulario.setApellido(apellidos);
                }catch (LetraException | LongitudException e){
                    System.out.println(e.getMessage());
                }

                case 3:
                    System.out.println("Introduce tu DNI");
                    String DNI = scanner.next();
                    formulario.setDNI(DNI);

                  try {
                      formulario.setDNI(DNI);
                  }catch (LetraException | LongitudException e){
                      System.out.println(e.getMessage());
                  }
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
            }

        } while (opcion != 4);
    }
}
