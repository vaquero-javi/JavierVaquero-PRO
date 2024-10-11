import java.util.Scanner;

public class For {
    /*
    FOR-->sirve para ejecuciones cerradas en numero
        for(inicio; final; incremento){
            lo que queremos que se repita
        }
     */
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Ejercicio1();
        //Ejercicio2();
        //Ejercicio3();
        Ejercicio4();

    }


    public static void Ejercicio1(){
        /*
        Se leerá el número de temperaturas a introducir (de ser 0 o negativo se establecerá a 10).
        Obténgase la media con dos decimales de las temperaturas introducidas por consola.
        (TemperaturasIntroducidas)
         */
            System.out.println("¿Cuantas temperaturas quieres introducir?");
            int numTemperaturas = scanner.nextInt();
            int temperatura = 0;
            int sumatorio = 0;

            if (numTemperaturas<1){
                numTemperaturas=10;
            }

            for (int i=0; i<numTemperaturas; i++){
                System.out.println("Introudce temperatura");
                temperatura=scanner.nextInt();
                sumatorio += temperatura;
            }
            System.out.println("La suma de todas las temperaturas es: "+sumatorio);
            System.out.println("La media de todas las temperaturas es: "+(float)sumatorio/numTemperaturas);
    }


    public static void Ejercicio2(){
        /*
        Leer un número entre 0 y 10. Se mostrará la tabla de multiplicar de dicho número con el formato:
        5 x 3 = 15 (desde 0 hasta 10 en líneas distintas). (TablaDeMultiplicar)
         */
            System.out.println("Introduce un numero para ver su tabla de multiplicar");
            int numero = scanner.nextInt();
            for (int i=0; i<11; i++) {
                System.out.printf("%d * %d = %d\n", numero, i, numero * i);
            }
    }


    public static void Ejercicio3(){
        //Modificar el ejercicio anterior para calcular la tabla de multiplicar de todos los números (TablaTodos)
            for (int i = 0; i < 11; i++) {
                System.out.println("Tabla de multiplicar del " +i);
                for (int a = 0; a < 11; a++) {
                    System.out.printf("%d * %d = %d\n", i,a,i*a);
                }
            }

    }

    public static void Ejercicio4(){
        /*
        Modificar el ejercicio anterior para calcular la tabla de multiplicar de los números
        comprendidos en un rango de números pedidos. Por ejemplo, las tablas de los números
        comprendidos entre el 3 y el 7 (3,4,5,6,7)
         */
        System.out.println("Dime cual es el numero inicial");
        int numInicial = scanner.nextInt();
        System.out.println("Dime cual es el numero final");
        int numFinal = scanner.nextInt();

        if (numInicial>=numFinal){
            System.out.println("No se puede ejecutar");
        }else {
            for (int i = numInicial; i <= numFinal; i++) {
                System.out.println("Tabla de multiplicar del " + i);
                for (int a = 0; a < 11; a++) {
                    System.out.printf("%d * %d = %d\n", i, a, i * a);
                }
            }
        }
    }

}



