import controller.Agenda;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        System.out.println("Introduce el nombre, apellido, telefono y dni");
        agenda.agregarPersona(scanner.nextLine(),scanner.nextLine(),scanner.nextInt(),scanner.nextLine());

    }
}
