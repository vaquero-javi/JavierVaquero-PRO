import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Ejercicio1();
        //Ejercicio2();
        Ejercicio3();
    }

    public static void Ejercicio1(){
        /*
        Realizar un programa que permita números mayores o iguales a cero por teclado hasta
        que se introduzca un número negativo y nos visualice el siguiente menú:
            1-Suma de los números pares introducidos.
            2-Media de los números pares introducidos con dos decimales.
            3-Media de los números impares introducidos con dos decimales.
            4-Cuántos números hemos introducido.
            5-Cuantos números de los introducidos han sido ceros, cuántos han sido pares y cuantos impares.
            6.-Salir.
         */
        int numero;
        int contadorPar=0, contadorImpar=0, contadorCeros=0;
        int sumatorioPar=0, sumatorioImpar=0;
        double mediaPar=0, mediaImpar=0;

        do {
            System.out.println("Introduce un numero");
            numero = scanner.nextInt();
            if (numero > -1) {
                if (numero%2 == 0) {
                    contadorPar++;
                    sumatorioPar+=numero;
                    mediaPar= (double) sumatorioPar /contadorPar;
                }else {
                    contadorImpar++;
                    sumatorioImpar+=numero;
                    mediaImpar= (double) sumatorioImpar/contadorImpar;
                }

                if (numero == 0) {
                    contadorCeros++;
                }
            }


        }while (numero>=0);
        System.out.println("1-Suma de los números pares introducidos.");
        System.out.println("2-Media de los números pares introducidos con dos decimales.");
        System.out.println("3-Media de los números impares introducidos con dos decimales.");
        System.out.println("4-Cuántos números hemos introducido.");
        System.out.println("5-Cuantos números de los introducidos han sido ceros, cuántos han sido pares y cuantos impares.");
        System.out.println("6.-Salir.");

        int opcion=0;
        do {

            System.out.println("¿QUÉ QUIERES SABER?");
            opcion= scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("La suma de los numeros pares introducidos es "+sumatorioPar);
                    break;
                case 2:
                    System.out.printf("La media de los numeros pares introducidos con dos decimales es %.2f\n",mediaPar);
                    break;
                case 3:
                    System.out.printf("La media de los numeros pares introducidos con dos decimales es %.2f\n",mediaImpar);
                    break;
                case 4:
                    System.out.printf("Has intoducido %d numeros\n",contadorCeros+contadorImpar+contadorPar);
                    break;
                case 5:
                    System.out.printf("Has introducido %d veces el numero 0. Has introducido %d veces numeros pares. " +
                            "Has introducido %d veces numeros impares\n",contadorCeros,contadorPar,contadorImpar);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        }while (opcion!=6);



    }

    public static void Ejercicio2(){
        /*
        Realizar un programa que pida las 20 notas de todos los alumnos de una clase. Al finalizar,
        imprimir por pantalla si hay algún suspenso y la nota media de todos los alumnos.
         */

        double notas;
        int suspenso=0;
        double sumatorio=0;
        for (int i = 0; i < 21; i++) {
            System.out.println("Dime la nota que has sacado");
            notas=scanner.nextDouble();
            if (notas > 0 && notas < 10) {
                if (notas < 5) {
                    suspenso++;
                }
                sumatorio+=notas;
            }else {
                System.out.println("Has introducido mal la nota");
                break;
            }

        }
        System.out.printf("Ha habido %d suspensos\n",suspenso);
        System.out.printf("La nota media de la clase es %.2f",sumatorio/20);
    }

    public static void Ejercicio3(){
        /*
            Desarrollar una aplicación que simule el funcionamiento de un cajero automático. Este
            cajero debe manejar el saldo de una cuenta donde se podrán realizar las siguientes operaciones:
                - Ingresar dinero: se pedirá el pin y un saldo a introducir. Al realizar la operación se
                    aparecerá el mensaje “saldo introducido con éxito”
                - Sacar dinero: se pedirá el pin y un saldo a sacar. solo se podrá hacer si el saldo
                    restante no es negativo. En caso de no poder sacar dinero aparecerá el mensaje
                    “Imposible sacar dinero”
                - Consultar el estado de la cuenta: se pedirá el pin y dice el saldo actual
                - Salir
            Consideraciones:
                - El saldo y las cantidades a ingresar deberán ser double
                - Cada vez que se realiza una operación se pedirá el PIN que deberá coincidir con 1111.
                  En caso de no coincidir aparecerá el mensaje de “Pin incorrecto” y volverá a salir el menú
         */

        String opciones;
        int pin=1111;
        double introducir=0;
        switch (opciones){
            case "Ingresar dinero":
                System.out.println("Introduce el PIN");
                pin=scanner.nextInt();
                System.out.println("Introduce el saldo a introducir");


        }
    }
}
