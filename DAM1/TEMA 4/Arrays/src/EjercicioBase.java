import java.util.Scanner;

public class EjercicioBase {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejerccio6();
        ejercicio7();
    }

    public static void ejercicio1() {
        //Realiza un programa que pida 10 números por teclado y que los almacene en un array.
        // A continuación se mostrará el contenido de ese array junto al índice (0 – 9)

        int numero[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un número");
            numero[i] = scanner.nextInt();
        }
        for (int i = 0; i < numero.length; i++) {
            System.out.printf("El numero en la posicion %d es %d\n", i + 1, numero[i]);
        }

    }

    public static void ejercicio2() {
        /*
        Crear un programa que genere 30 números aleatorios entre 0 - 10 y los guarde en un array.
        Una vez metidos, se deberá mostrar:
            - Numero de puntos obtenidos
            - Media de puntos obtenidos
         */

        int numero[] = new int[30];
        int contador = 0;
        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random() * 11);
            System.out.println("El numero obtenido es " + numero[i]);
            contador += numero[i];
        }
        System.out.println("El numero de puntos obtenidos es " + contador);
        System.out.println("La media de puntos obtenidos es " + contador / numero.length);

    }

    public static void ejercicio3() {
        /*
        3. Escribe un programa que lea 10 números por teclado, los guarde en un array y que luego los muestre:
            - en orden inverso, es decir, el primero que se introduce es el último en mostrarse
            - en orden normal, es decir, el primero que se muestra es el primero que se ha introducido
         */

        int[] numero = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un numero");
            numero[i] = scanner.nextInt();
        }

        System.out.println("En orden inverso, es decir, el primer numero introducido será el último en ser mostrado");
        for (int i = numero.length - 1; i >= numero[0]; i--) {
            System.out.println(numero[i]);
        }
        System.out.println("En orden normal, es decir, el primer numero introducido será el primero en ser mostrado");
        for (int item2 : numero) {
            System.out.println(item2);
        }

    }

    public static void ejercicio4() {
        /*
        4. Define tres arrays de 20 números enteros cada una, con nombres numero, cuadrado y cubo.
        Carga el array numero con valores aleatorios entre 0 y 100.
            - En el array cuadrado se deben almacenar los cuadrados de los valores que hay en el array numero.
            - En el array cubo se deben almacenar los cubos de los valores que hay en numero.
         */
        int[] numero = new int[20];
        int[] cuadrado = new int[numero.length];
        int[] cubo = new int[numero.length];

        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random() * 101);
            System.out.println("El numero es: " + numero[i]);

            for (int j = 0; j < 1; j++) {
                cuadrado[j] = numero[i] * numero[i];
                System.out.printf("El cuadrado de %d es: %d\n", numero[i], cuadrado[j]);
            }

            for (int j = 0; j < 1; j++) {
                cubo[j] = numero[i] * numero[i] * numero[i];
                System.out.printf("El cubo de %d es: %d\n", numero[i], cubo[j]);
            }
            System.out.println("===========================================");
        }
    }

    public static void ejercicio5() {
        /*
        Realiza un programa que pida 8 números enteros, los guarde en un array y que luego muestre esos
        números junto con la palabra “par” o “impar” según proceda.
         */
        int[] numero = new int[8];
        for (int i = 0; i < numero.length; i++) {
            System.out.println("Introduce un numero");
            numero[i] = scanner.nextInt();

        }
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] % 2 == 0) {
                System.out.printf("El numero %d es par\n", numero[i]);
            } else {
                System.out.printf("El numero %d es impar\n", numero[i]);
            }
        }
    }

    public static void ejerccio6() {
        /*
        2. Escribe un programa que rellene un array de 20 números aleatorios entre el 0 y el 30.
        Una vez hecho esto realizará las siguientes operaciones:
            - modificar todos los 6 por 8
            - modificar todos los 7 por 15
            - modificar todos los 20 por 10
         Al finalizar el programa deberá indicar cuántas modificaciones se han realizado.
         */
        int[] numero = new int[20];
        int contador = 0;
        System.out.println("20 numeros aleatorios del 0-30:");
        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random() * 31);
            System.out.println(numero[i]);
        }
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] == 6) {
                numero[i] = 8;
                contador++;
            }

            if (numero[i] == 7) {
                numero[i] = 15;
                contador++;
            }

            if (numero[i] == 20) {
                numero[i] = 10;
                contador++;
            }
            System.out.println("Los numeros modificados: " + numero[i]);
        }
        System.out.printf("Hay un total de %d modificaciones hechas\n", contador);
    }

    public static void ejercicio7() {
        /*
        1. Crea un programa que pida 10 palabras por consola y las guarde en un array de String.
        Una vez hecho esto saldrá un menú que me dará las siguientes opciones:
            - Ver todas las palabras: mostrarla todas las palabras del array
            - Obtener una palabra al azar: mostrará una palabra de las que existen en el array
            - Ver número de letras: mostrará el número de letras que hay en total entre todas las palabras
            - Ver media de letras: mostrará el número medio de letras entre todas las palabas
            - Ver palabra con más letras
            - Ver palabra con menos letras
         */
        int opcion = 0;
        int contadorLetras = 0;
        String[] palabra = new String[10];
        for (int i = 0; i < palabra.length; i++) {
            System.out.println("Introduce una palabra");
            palabra[i] = scanner.nextLine();
        }
        do {
            System.out.println("1-Ver todas las palabras");
            System.out.println("2-Obtener una palabra al azar");
            System.out.println("3-Ver número de letras");
            System.out.println("4-Ver media de letras");
            System.out.println("5-Ver palabra con más letras");
            System.out.println("6-Ver palabra con menos letras");
            System.out.println("7-SALIR");
            System.out.println("¿QUÉ QUIERES HACER?");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    for (String item : palabra) {
                        System.out.print(item + " , ");
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int i = 0; i < palabra.length; i++) {
                        int aletorio = (int) (Math.random() * palabra.length);
                        System.out.print(palabra[aletorio]);
                    }
                    System.out.println();
                    break;
                case 3:
                    for (String item : palabra) {
                        contadorLetras += item.length();
                    }
                    System.out.println(contadorLetras);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;

            }
        } while (opcion != 7);

    }
}
