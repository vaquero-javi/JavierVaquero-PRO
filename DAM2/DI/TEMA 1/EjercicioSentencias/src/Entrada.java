import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        EjerciciosIf ejerciciosIf = new EjerciciosIf();
        EjerciciosSwitch ejerciciosSwitch = new EjerciciosSwitch();
        EjerciciosFor ejerciciosFor = new EjerciciosFor();

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
                    //ejerciciosIf.validarFecha();
                    //ejerciciosIf.diaSiguiente();
                    break;
                case 2:
                    //ejerciciosSwitch.vocalOconsonante();
                    //ejerciciosSwitch.parOimpar();
                    //ejerciciosSwitch.calculadora();
                    //ejerciciosSwitch.mesAanio();
                    break;
                case 3:
                    //ejerciciosFor.mediaTemperaturas();
                    //ejerciciosFor.tablaDeMultiplicar();
                    //ejerciciosFor.todasLasTablasDeMultiplicar();
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("No has introducido ningún número de la lista");
                    break;
            }

        }while (opcion !=4);
    }

}




