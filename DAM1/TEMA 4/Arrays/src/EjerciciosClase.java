import java.util.Scanner;

public class EjerciciosClase {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        ejercicio5();
    }

    public static void ejercicio1() {
        /*
        1. (MultiplicarArray) Crear un array de 5 posiciones:
            - se le pedirá al usuario que introduzca cada unos de los elementos del array
            - Multiplica cada elemento del array * 2 y vuelve a guardar su valor
            - Saca por consola la suma de todos los números
            - Saca la media de todos los elementos
         */
        int[] numero = new int[5];
        int sumatorio = 0;

        for (int i = 0; i < numero.length; i++) {
            System.out.println("Introduce un numero");
            numero[i] = scanner.nextInt();
            System.out.println("Se multiplica el valor por 2");
            numero[i] *= 2;
        }
        for (int i = 0; i < numero.length; i++) {
            sumatorio += numero[i];
            System.out.println("La suma de todos los numeros son " + sumatorio);
            System.out.println("La media es " + (double) sumatorio / numero.length);
        }
    }

    public static void ejercicio2() {
        /*
        2. (MayorArray) Crea una aplicación que realice lo siguiente:
            - pida por pantalla la longitud del array de enteros
            - crea el array de enteros con la longitud introducida
            - pida al usuario que introduzca todos los datos del array
            - saque por pantalla el elemento mayor y el elemento menor
         */
        System.out.println("¿Cúal quieres que sea la longitud del array?");
        int[] numero = new int[scanner.nextInt()];
        for (int i = 0; i < numero.length; i++) {
            System.out.println("Introduce un numero");
            numero[i] = scanner.nextInt();
        }

        int numMayor = numero[0];
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] > numMayor) {
                numMayor = numero[i];
            }
        }
        System.out.println("El numero mayor es " + numMayor);

        int numMenor = numMayor;
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] < numMenor) {
                numMenor = numero[i];
            }
        }
        System.out.println("El numero menor es " + numMenor);

    }

    public static void ejercicio3() {
        /*
        3. (SumaArrays) Crear una aplicación que:
            - pida la longitud de dos arrays de enteros
            - crea los array de enteros con las longitudes introducidas
            - crea un tercer array de la misma longitud que los dos anteriores
            - rellena el tercer array con la suma de las posiciones
            (Array1.posicion1 + array2.posicion = array3.posicion)
         */
        System.out.println("¿Cúal quieres que sea la longitud de los dos primeros array?");
        int[] numero1 = new int[scanner.nextInt()];
        int[] numero2 = new int[numero1.length];
        int[] numero3 = new int[numero1.length];

        for (int i = 0; i < numero1.length; i++) {
            System.out.println("Introduce un numero para el 1er array");
            numero1[i] = scanner.nextInt();
        }

        for (int i = 0; i < numero2.length; i++) {
            System.out.println("Introduce un numero para el 2o array");
            numero2[i] = scanner.nextInt();
        }

        for (int i = 0; i < numero3.length; i++) {
            numero3[i] = numero2[i] + numero1[i];
            System.out.println(numero3[i]);
        }
    }

    public static void ejercicio4() {       //!!!!NO SE HACERLO!!!!!!!!!!
        /*
        4. (PosicionesArray) Crea una aplicación que:
            - pida por teclado la longitud de un array
            - cree el array de enteros de la longitud introducida
            - pida al usuario que introduzca todos los datos del array
            - mueva una posición todos los elementos. el elemento de la posición 0 pasa a la posición 1 y así
                sucesivamente. El elemento que está en la última posición pasa a la primera
            - realizar la tarea anterior pero al contrario. El elemento que está en la
                primera posición pasa a la última y así sucesivamente
         */
        System.out.println("Introduce la longitud de tu array");
        int[] numero = new int[scanner.nextInt()];
        for (int i = 0; i < numero.length; i++) {
            System.out.println("Introduce un numero");
            numero[i] = scanner.nextInt();
        }

        for (int i = 0; i < numero.length; i++) {
            do {
                if (numero[i] < numero[numero.length]) {
                    numero[i]++;
                } else {
                    numero[numero.length] = numero[0];
                }

            } while (numero[i] >= numero[numero.length]);

        }
        for (int item : numero) {
            System.out.print(item + " ");
        }
    }

    public static void ejercicio5() {
        /*
        1. (OperacionesArray) Crear un array con 10 posiciones y asígnale números enteros entre 0 y 9,
        ambos inclusive (de forma automática). Se mostrarán los datos separados por una coma y un espacio.
        Una vez hecho esto se modificará el array del de la manera indicada en cada apartado, y se mostrará de nuevo.
            - Incrementar en 1 los valores pares y en -1 los impares.
            - Duplicar los valores positivos menores que 5
            - Sumar a cada valor un valor entero aleatorio entre -5 y 5.
            - Mover los datos una posición hacia la derecha (el primero pasa al segundo, el
                segundo al tercero, ..., y el último al primero).
            - Intercambiar el primero con el segundo, el tercero con el cuarto, ..., el penúltimo con el último.
            - Invertir el array
            - Mostrar la posición del primer par y del último impar.

        hay que hacer todo de golpe, pero opcionalmente se puede hacer un menú que indique cada una de las opciones
         */
        int[] numero = new int[10];
        System.out.println("Los valores del array son:");
        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random() * 10);
            System.out.print(numero[i] + ", ");
        }
        System.out.println();

        System.out.println("Le sumamos 1 a los pares y le restamos 1 a los impares");
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] % 2 == 0) {
                numero[i]++;
            } else {
                numero[i]--;
            }
            System.out.print(numero[i] + ", ");
        }
        System.out.println();

        System.out.println("Duplicamos los valores que estén entre 0 y 5");
        for (int i = 0; i < numero.length; i++) {
            if (numero[i] > 0 && numero[i] < 6) {
                numero[i] *= 2;
            }
            System.out.print(numero[i] + ", ");
        }
        System.out.println();

        System.out.println("Sumamos un valor aleatorio entre -5 y +5");
        for (int i = 0; i < numero.length; i++) {
            numero[i] *= (int) (Math.random() * 11) - 5;
            System.out.print(numero[i] + ", ");
        }
        System.out.println();

        System.out.println("Cambiamos la posición de los numeros uno hacia la derecha");
        int guardarNum = numero[numero.length-1];
        for (int i = numero.length - 1; i > 0; i--) {
            numero[i] = numero[i - 1];      //¿POR QUÉ AQUI SE LE RESTA UNO EN VEZ DE SUMARLE UNO?

        }
        numero[0]=guardarNum;
        for (int item: numero){
            System.out.print(item+", ");
        }
        System.out.println();

        System.out.println("Intercambiar el primero con el segundo, el tercero con el cuarto, ...");
    }
}
