import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        EjerciciosIf ejerciciosIf = new EjerciciosIf();


        int opcion;

        do {
            System.out.println("¿Qué ejercicios quieres ver?");
            System.out.println("1-Ejercicios IF");
            System.out.println("2-Ejercicios SWITCH");
            System.out.println("3-Ejercicios FOR");
            System.out.println("4-Salir de los ejercicios");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    //ejerciciosIf.comparaDosEnteros();
                    //ejerciciosIf.multiploYrango();
                    //ejerciciosIf.capicua();
                    //ejerciciosIf.incrementoYdecremento();
                    //ejerciciosIf.incrementoXcondicionales();
                    ejerciciosIf.validarFecha();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    System.out.println("No has introducido ningún número de la lista");
            }

        }while (opcion !=4);
    }

}




