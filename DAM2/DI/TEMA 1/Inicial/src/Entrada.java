import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Primer programa de repaso");
        // Variables -> guardar un valor que será utilizado en varias ocasiones
        final String DNI = "123456A";
        System.out.println("Introduce tu nombre");
        String nombre = scanner.next();
        String correo; //null
        System.out.println("Introduce tu edad");
        int edad = scanner.nextInt();
        //Array -> lista no dinamica
        //ArrayList // Hastable -> lista dinamica

        System.out.printf("Mi nombre es %s y tengo %d anos%n", nombre,edad);


        //Sentencias de control

    }

}
