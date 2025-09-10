import java.util.Arrays;
import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        ejercicio3();
    }

    public static void ejercicio1() {
        /*Crear una aplicación que sea capaz de rellenar un array de 15 elementos sin que se
        repita ninguno de ellos. Para ello, los números que se meterán son aleatorios entre 0 y
        16. Una vez hecho esto:
            - Muestra los elementos del array sin ordenar.
            - Muestra los elementos del array ordenados.
            - Muestra solo los elementos que están en posiciones pares
            - Muestra solo los elementos que son pares

         */
        int[] numero = new int[15];
        int numAleatorio = 0;
        for (int i = 0; i < numero.length; i++) {
            numAleatorio = (int) (Math.random() * 17);
            if (numero[i] != numAleatorio) {
                numero[i] += numAleatorio;
            }

            System.out.print(numero[i] + "\t");
        }
        System.out.println();

        System.out.println("Mostrar el array ordenado");
        Arrays.sort(numero);
        for (int i = 0; i < numero.length; i++) {
            System.out.print(numero[i] + "\t");
        }
        System.out.println();

        System.out.println("Posiciones pares");
        for (int i = 0; i < numero.length; i++) {
            if (numero[i % 2] == 0) {
                System.out.print(numero[i] + "\t");
            }

        }
        System.out.println();
        System.out.println("Elementos pares");
        for (int i = 0; i < numero.length; i++) {
            if (numero[i]%2 == 0) {
                System.out.print(numero[i] + "\t");
            }

        }
    }


    public static void ejercicio2() {
        /*
        Desarrolla un programa que tenga las siguientes funcionalidades
            - Pedir al usuario la cantidad de datos que se quieren guardar
            - Rellene automáticamente la lista con números aleatorios entre 0 y 20
            - Una vez relleno se deberán de hacer automáticamente las siguientes acciones
            - System.out.println("** mostrar extremos"); Mostrará el elemento más grande y el elemento más pequeño
            - System.out.println("** mostrar par/impar"); Mostrará cuantos elementos son pares y cuantos impares
            - System.out.println("** mostrar repeticiones"); Pedirá un número por teclado y mostrará el número
                de veces que aparece en la lista
         */
        System.out.println("Introduce la cantidad de datos que quieres guardar");
        int[] guardarDatos = new int[scanner.nextInt()];
        for (int i = 0; i < guardarDatos.length; i++) {
            guardarDatos[i] = (int) (Math.random() * 21);
        }
        System.out.println("Mostrar extremos:");
        int numPequnio = 21;
        int numGrande = -1;
        for (int i = 0; i < guardarDatos.length; i++) {
            if (guardarDatos[i] < numPequnio) {
                numPequnio = guardarDatos[i];
            }
            if (guardarDatos[i] > numGrande) {
                numGrande = guardarDatos[i];
            }
        }
        System.out.println("El numero más pequeño es " + numPequnio + " y el mas grande es " + numGrande);

        System.out.println("Mostrar par/impar:");
        int contadorPar = 0;
        int contadorImpar = 0;
        for (int i = 0; i < guardarDatos.length; i++) {
            if (guardarDatos[i] % 2 == 0) {
                contadorPar++;
            } else {
                contadorImpar++;
            }
        }
        System.out.printf("Impares %d \t Pares %d\n", contadorImpar, contadorPar);

        System.out.println("Introduce un numero y te digo las veces que esta repetido");
        int numRepe = 0;
        int num = scanner.nextInt();
        for (int i = 0; i < guardarDatos.length; i++) {
            if (num == guardarDatos[i]) {
                numRepe++;
            }
        }
        System.out.printf("El numero %d ha salido repetido %d veces", num, numRepe);
    }

    public static void ejercicio3() {
        /*
        Desarrollar un programa que tenga las siguientes funcionalidades sobre un
        array de 20 números, mediante un menú ofrezca las siguientes posibilidades
            a. Registrar posiciones; pedirá por teclado una a una las posiciones del array.
            b. Obtener elementos de una posición pedirá por teclado una posición y mostrará el dato asociado a dicha posición.
            c. Mostrar el array completo; listará el array completo, elemento a elemento
            d. Mostrar el array ordenado (con el algoritmo de la burbuja; lista el
                array completo ordenado de menor a mayor
            e. Rotar el array mueve todas las posiciones del array en una dirección (la
                que tu elijas) y lo muestra
         */
        int[] numero = new int[20];
        int opcion = 0;
        int elemento = -1;

        do {
            System.out.println("1.Registrar posiciones");
            System.out.println("2.Obtener elementos de una posicion");
            System.out.println("3.Mostrar el array completo");
            System.out.println("4.Mostrar el array ordenado");
            System.out.println("5.Mover elementos a la derecha");
            System.out.println("6.Salir");

            System.out.println("¿Qué quieres hacer?");
            opcion=scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Registrar posiciones");
                    for (int i = 0; i < numero.length; i++) {
                        System.out.println("Introduce numero");
                        numero[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Obtener elementos de una posicion");
                    elemento = scanner.nextInt();
                    for (int i = 0; i < numero.length; i++) {
                        System.out.println(numero[elemento]);
                    }
                    break;
                case 3:
                    System.out.println("Mostrar el array completo");
                    for (int item : numero[]) {
                        System.out.print(item);
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Mostrar el array ordenado");
                    Arrays.sort(numero);
                    for (int i = 0; i < numero.length; i++) {
                        System.out.print(numero[i] + "\t");
                    }
                case 5:
                    System.out.println("Mover elementos a la derecha");
                    int ultimoNum = numero[numero.length - 1];
                    for (int i = numero.length - 1; i > 0; i--) {
                        numero[i] = numero[i - 1];
                    }
                    numero[0] = ultimoNum;
                    for (int i = 0; i < numero.length; i++) {
                        System.out.println(numero[i]);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;

            }

        } while (opcion != 6);
    }

    public static void ejercicio4() {
        /*
        Realizar una aplicación que gestione usuarios mediante array multidimensional
        donde se podrán guardar 10 elementos, donde los cuales constan de nombre
        (string), apellido (string), teléfono (int) y dni (string): La funcionalidad de la
        aplicación se guiará por un menú con las siguientes opciones:
            - Agregar persona: Pedirá los daos de nombre, apellido, teléfono y dni. Una vez
                pedidos agregará la persona en la lista. En el caso de no poder agregar más por
                estar la lista llena saltará un aviso.
            - Buscar persona: Pedirá un dni y sacará por pantalla todos los datos de la
                persona asociada con el formato Nombre: XXX, Apellido: XXX, Teléfono: XXX
            - Listar personas: Listará todos los elementos existentes en la lista con el
                formatoNombre: XXX, Apellido: XXX, Teléfono: XXX
         */
        
    }
}

