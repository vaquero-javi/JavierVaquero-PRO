import controller.Agenda;

import java.util.Scanner;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Introduce el nombre, apellido, telefono y dni");
        if (agenda.agregarPersona(scanner.next(),scanner.next(),scanner.nextInt(),scanner.next())){
            System.out.println("Usuario agregado correctamente");
        }else {
            System.out.println("Usuario ya registrado");
        }

        switch (agenda.listarDatosPersona("1234a")){
            case 1:
                System.out.println("No se pueden hacer busquedas porque la lista está vacía");
                break;
            case 2:
                System.out.println("No está en la lista ¿Quieres agregarlo? (s/n)");
                String contestacion = scanner.next();
                if (contestacion.equalsIgnoreCase("s")){
                    //pido datos
                    //agregar persona

                }else {
                    System.out.println("Continuando con la lista");
                }
                break;
            case 3:
                break;
        }


    }
}