import java.util.Scanner;

public class While {
    //Es un bucle de repetición que se usa en caso de condiciones (true)
    //de 0 a n veces
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Ejemplo();
        //Ejercicio1();
        //Ejercicio2(); (NO ESTÁ HECHO!!)
        //Ejercicio3();
        Ejercicio4();
    }

    public static void Ejemplo() {
        //PEDIR POR CONSOLA QUE NUMEROS HASTA QUE EL USUARIO INTRODUZCA 0 Y SABER CAUANTOS NUMEROS HA INTRODUCIDO
        //HASTA LLEGAR AL NUMERO VERDADERO
        int contador = 0;
        int numero = -1;
        while (numero != 0) {
            contador++;
            System.out.println("Introduce un numero hasta adivinar el numero");
            numero = scanner.nextInt();
        }
        System.out.println("Enhorabuena! Has acertado el numero");
        System.out.printf("Has introducido %d veces hasta acertarlo", contador);
    }

    public static void Ejercicio1() {
        /*
        Leer números enteros hasta introducir un 0. El programa obtendrá la suma de todos
        los números positivos. (SumarPositivos)
         */
        int numero;
        int sumatorio = 0;
        do {
            System.out.println("Introduce un numero");
            numero = scanner.nextInt();
            if (numero > 0) {
                sumatorio += numero;
            }
            System.out.printf("La suma de todos los numeros positivos que has introducido es %d", sumatorio);
        } while (numero != 0);
    }

    public static void Ejercicio2() {
        /*
        Calcúlese el mínimo común múltiplo de dos números entre 1 y 100. Para obtener el mcm se tomará uno de los
        valores introducidos y se irá multiplicando por 1, 2, 3, etc, hasta que el valor obtenido sea múltiplo del
        otro número, que sería el valor buscado. (MinimoComunMultiplo)
         */

    }

    public static void Ejercicio3() {
        /*
        Generar números enteros aleatorios entre 0 y 100 hasta obtener el 0. El programa mostrará cada uno de los
        datos generados y obtendrá el mayor de los números generados. (MayorNumero)
         */
        int numeroAlatorio;
        int i = 0;
        do {
            numeroAlatorio = (int) (Math.random() * 101);
            System.out.println(numeroAlatorio);
            if (numeroAlatorio > i) {
                i = numeroAlatorio;
            }
        } while (numeroAlatorio != 0);
        System.out.println("El dato aleatorio más alto que se ha mostrado en pantalla es " + i);
    }

    public static void Ejercicio4() {
        /*
        Introducir un entero no negativo, y convertirlo a binario, octal y hexadecimal. (BinarioOctalHexadecimal)
         */
        System.out.println("Introduce un numero para convertirlo a binario, octal, hexadecimal");
        int numero = scanner.nextInt();
        int numeroOctal = numero;
        int numeroHexadecimal = numero;
        int resto;

        String guardarNumBinario = "";
        String guardarNumOctal = "";
        String guardarNumHexadecimal = "";
        String binario = "";
        String octal ="";
        int hexadecimal;
        if (numero < 0) {
            System.out.println("Introduce un numero positivo");
        } else {
            System.out.println("CONVERTIMOS A BINARIO:");
            do {
                resto = numero % 2;
                numero /= 2;
                guardarNumBinario += resto;
            } while (numero > 1);
            guardarNumBinario += 1;
            for (int i = guardarNumBinario.length() - 1; i >= 0; i--) {
                binario += guardarNumBinario.charAt(i);
            }
            System.out.printf("El binario es %s\n", binario);


            System.out.println("CONVERTIMOS A HEXADECIMAL");                //!!NO ME SALEEEE!!!
            switch (hexadecimal =Integer.parseInt(binario)){
                case 1010:
                    System.out.println("A");
                    break;
                case 1011:
                    System.out.println("B");
                    break;
                case 1100:
                    System.out.println("C");
                    break;
                case 1101:
                    System.out.println("D");
                    break;
                case 1110:
                    System.out.println("E");
                    break;
                case 1111:
                    System.out.println("F");
                    break;
            }

            System.out.println("CONVERTIMOS A OCTAL:");
            do {
                resto = numeroOctal % 8;
                numeroOctal /= 8;
                guardarNumOctal += resto;
            } while (numeroOctal > 7);
            guardarNumOctal += 1;
            for (int i = guardarNumOctal.length() - 1; i >= 0; i--) {
                octal += guardarNumOctal.charAt(i);
            }
            System.out.printf("El octal es %s\n", octal);





        }

    }

}
