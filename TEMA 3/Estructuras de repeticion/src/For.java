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
        //Ejercicio4();
        //Ejercicio5();
        //Ejercicio6();
        //Ejercicio7();
        //Ejercicio8();
        //Ejercicio9();
        //Ejercicio10();
        //Ejercicio11();
        //SacarLetra();
        //Ejercicio13();
        //Ejercicio14();
        //Ejercicio15();
        //Ejercicio16();
        //Ejercicio17();


    }


    public static void Ejercicio1() {
        /*
        Se leerá el número de temperaturas a introducir (de ser 0 o negativo se establecerá a 10).
        Obténgase la media con dos decimales de las temperaturas introducidas por consola.
        (TemperaturasIntroducidas)
         */
        System.out.println("¿Cuantas temperaturas quieres introducir?");
        int numTemperaturas = scanner.nextInt();
        int temperatura = 0;
        int sumatorio = 0;

        if (numTemperaturas < 1) {
            numTemperaturas = 10;
        }

        for (int i = 0; i < numTemperaturas; i++) {
            System.out.println("Introudce temperatura");
            temperatura = scanner.nextInt();
            sumatorio += temperatura;
        }
        System.out.println("La suma de todas las temperaturas es: " + sumatorio);
        System.out.println("La media de todas las temperaturas es: " + (float) sumatorio / numTemperaturas);
    }

    public static void Ejercicio2() {
        /*
        Leer un número entre 0 y 10. Se mostrará la tabla de multiplicar de dicho número con el formato:
        5 x 3 = 15 (desde 0 hasta 10 en líneas distintas). (TablaDeMultiplicar)
         */
        System.out.println("Introduce un numero para ver su tabla de multiplicar");
        int numero = scanner.nextInt();
        for (int i = 0; i < 11; i++) {
            System.out.printf("%d * %d = %d\n", numero, i, numero * i);
        }
    }

    public static void Ejercicio3() {
        //Modificar el ejercicio anterior para calcular la tabla de multiplicar de todos los números (TablaTodos)
        for (int i = 0; i < 11; i++) {
            System.out.println("Tabla de multiplicar del " + i);
            for (int a = 0; a < 11; a++) {
                System.out.printf("%d * %d = %d\n", i, a, i * a);
            }
        }

    }

    public static void Ejercicio4() {
        /*
        Modificar el ejercicio anterior para calcular la tabla de multiplicar de los números
        comprendidos en un rango de números pedidos. Por ejemplo, las tablas de los números
        comprendidos entre el 3 y el 7 (3,4,5,6,7)
         */
        System.out.println("Dime cual es el numero inicial");
        int numInicial = scanner.nextInt();
        System.out.println("Dime cual es el numero final");
        int numFinal = scanner.nextInt();

        if (numInicial >= numFinal) {
            System.out.println("No se puede ejecutar");
        } else {
            for (int i = numInicial; i <= numFinal; i++) {
                System.out.println("Tabla de multiplicar del " + i);
                for (int a = 0; a < 11; a++) {
                    System.out.printf("%d * %d = %d\n", i, a, i * a);
                }
            }
        }
    }

    public static void Ejercicio5() { //no se hacerlo!!!!!!
        /*
        Dado dos enteros entre 0 y 5 (la base y el exponente), obtener la potencia del primero elevado
        al segundo sin utilizar el método “pow”. Por ejemplo, base = 3 y exponente = 5, 35=3x3x3x3x3=243.
        Casos particulares: 00 = Error y n0 = 1.(BaseExponente)
         */
        System.out.println("Introduce un numero para la base entre 0-5");
        int base = scanner.nextInt();
        System.out.println("Introduce un numero para el exponente entre 0-5");
        int exponente = scanner.nextInt();
        int resultado = 1;


        if (base == 0) {
            System.out.println("Error");
        } else if (exponente == 0) {
            System.out.printf("%d x %d = 1", base, exponente);
        } else {
            for (int i = 0; i < exponente; i++) {
                resultado = resultado * base;
            }
            System.out.println("El resultado de la potencia es " + resultado);
        }

    }

    public static void Ejercicio6() {
        /*
        Mostrar todos los números pares comprendidos entre dos dados. (ParesEntreDosDados)
         */
        System.out.println("Di desde que numero quieres calcular");
        int numInicial = scanner.nextInt();
        System.out.println("Di hasta que numero quieres calcular");
        int numFinal = scanner.nextInt();
        for (int i = numInicial; i <= numFinal; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void Ejercicio7() {
        /*
        Simúlese el lanzamiento de un dado. Se introducirá el número de veces que se lanza el dado
        (de no ser positivo, se establecerá a 100). (Dado)
         */
        System.out.println("¿Cuantas veces quieres tirar el dado?");
        int numeroVeces = scanner.nextInt();
        if (numeroVeces < 1) {
            System.out.println("No se pueden tirar veces negativas");
            numeroVeces = 100;
        }
        for (int i = 1; i <= numeroVeces; i++) {
            int tirada = (int) (Math.random() * 6) + 1;
            System.out.printf("La tirada numero %d es %d\n", i, tirada);
        }
    }

    public static void Ejercicio8() {
        /*
        Pedir 10 números. Mostrar la media de los números positivos, la media de los
        números negativos y la cantidad de ceros (NumerosTipos)
         */
        int acumuladorPositivos = 0, acumuladorNegativos = 0, numeroCeros = 0, numeroPositivos = 0, numeroNegativos = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el numero que quieres");
            int numero = scanner.nextInt();
            if (numero < 0) {
                acumuladorNegativos += numero;
                numeroNegativos++;
            } else if (numero > 0) {
                acumuladorPositivos += numero;
                numeroPositivos++;
            } else {
                numeroCeros++;
            }
        }
        System.out.println("La media de positivos es " + ((float) acumuladorNegativos / numeroNegativos));
        System.out.println("La media de negativos es " + ((float) acumuladorPositivos / numeroPositivos));
        System.out.println("El numero de ceros es " + numeroCeros);
    }

    public static void Ejercicio9() {
        int sueldosMayores = 0, sumatoriosSueldos = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce sueldo");
            int sueldo = scanner.nextInt();
            if (sueldo > 1000) {
                sueldosMayores++;
            }
            sumatoriosSueldos += sueldo;
        }
        System.out.println("El numero de sueldos mayores que 1000 son " + sueldosMayores);
        System.out.println("El sumatorio de todos los sueldos es " + sumatoriosSueldos);
        System.out.println("La madia de todos los sueldos es " + (float) sueldosMayores / sumatoriosSueldos);
    }

    public static void Ejercicio10() {
        int numeroSS = 0, numeroAP = 0, numeroCD = 0;
        for (int i = 0; i < 6; i++) {
            System.out.println("Introduce una nota");
            int nota = scanner.nextInt();
            if (nota >= 0 && nota <= 10) {
                if (nota > 4) {
                    numeroAP++;
                } else if (nota < 4) {
                    numeroSS++;
                } else {
                    numeroCD++;
                }
            } else {
                System.out.println("Nota invalida");
            }
        }
        System.out.println("EL numero de AP es " + numeroAP);
        System.out.println("El numero de SS es " + numeroSS);
        System.out.println("El numero de CD es " + numeroCD);
    }

    public static void Ejercicio11() {
        System.out.println("De que lado quieres el cuadrado");
        int lado = scanner.nextInt();
        for (int i = 0; i < lado; i++) {
            System.out.println("\t+\t");
            for (int j = 0; j < lado; j++) {
                if (i == 0 || i == lado - 1) {     //primera y ultimma fila
                    System.out.print("\t+\t");
                } else if (j == 0 || j == lado - 1) {     //primera y ultima columna
                    System.out.print("\t+\t");
                } else {
                    System.out.println("\t \t");
                }
            }
            System.out.println();
        }
    }

    public static void SacarLetra() {
        String palabra1 = "Hola que tal";
        palabra1 = palabra1.replaceAll(" ", ""); //sirve para quitar todos los espacios
        for (int i = 0; i < palabra1.length(); i++) {
            char letra = palabra1.charAt(i);
            System.out.println(letra);
        }
    }

    public static void Ejercicio13() {
        /*
        Pedir una palabra por teclado y mostrar su contraria. Por ejemplo se introducirá la palabra 
        programacion y se mostrará por consola la palara noicamargorp (InversaPalabra)
         */
        System.out.println("Introduce una palabra para hacer su contraria");
        String palabra = scanner.nextLine();
        for (int i = palabra.length() - 1; i >= 0; i--) {
            System.out.print(palabra.charAt(i));

        }
    }

    public static void Ejercicio14() {
        /*
        Pedir una palabra por teclado y comprobar si es o con capicua. Una palabra es palíndromo
        cuando se lee igual de izquieda a derecha que de derecha a izquierda. Por ejemplo ana, oro, radar.
        Para poder hacer la comprobacion no se tendrán en cuenta mayusculas ni acentos (CapicuaPalabra)
         */
        System.out.println("Introduce una palabra para ver si es capicua");
        String palabra = scanner.nextLine();
        palabra = palabra.toLowerCase()
                .replaceAll("á", "a")
                .replaceAll("é", "e")
                .replaceAll("í", "i")
                .replaceAll("ó", "o")
                .replaceAll("ú", "u");
        boolean palindromo = true;
        for (int i = 0; i < palabra.length() / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                palindromo = false;
                break;
            }
        }
        if (palindromo) {
            System.out.println("Tu palabra es palindromo");
        } else {
            System.out.println("Tu palabra no es palindromo");
        }
    }

    public static void Ejercicio15() {
        /*
        15. Pedir por consola una frase. Una vez introducida. Indicar:
            1. Cuantas oraciones tiene
            2. Cuantas letras tiene
            3. Cuantas palabras tiene
            4. Cuantas letras tiene (sin contar espacios ni símbolos de puntuación)
         */
        System.out.println("Introduce una frase");
        String frase = scanner.nextLine();

        //numero de letras
        int numLetras = frase.length();

        //numero de letras sin espacios ni puntos
        int numLetrasSinCosas = frase.replaceAll(" ", "").replaceAll("\\.","").length();

        //numero de palabras
        //numero de oraciones
        int numOraciones=0;
        int numPalabras=0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == '.'){
                numOraciones++;
            } else if (frase.charAt(i) == ' ') {
                numPalabras++;
            }
        }
        numPalabras+=(numOraciones-1);
        System.out.println("El numero de frases "+numOraciones);
        System.out.println("El numero de palabras "+numPalabras);
        System.out.println("El numero de letras "+numLetras);
        System.out.println("El numero de letras sin cosas "+numLetrasSinCosas);
    }

    public static void Ejercicio16(){
        /*
        Crear un programa que permita realizar un juego de adivinación. Para ello el sistema nada más empezar
        generará un número aleatorio entre 1 y 30. Tras la generación de este número el usuario contará con 10
        intentos para poder adivinarlo. Para lo cual se irá pidiendo un números y en el caso de aceptarlo
        terminará el proceso con el mensaje "Has adivinado el número en X intentos". En el caso de agotar los
        intentos aparecerá el menaje "Lo siento, has agotado todos los intentos”
         */
        int aleatorio = (int) (Math.random()*30)+1;
        int intentos =0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Dime tu numero");
            int numeroUsuario = scanner.nextInt();
            intentos++;
            if (aleatorio == numeroUsuario){
                System.out.println("Enhorabuena has acertado");
                break;
            }else {
                System.out.println("Intentalo de nuevo");
            }
        }
        System.out.println("El numero de intentos gastados es "+intentos);
    }

    public static void Ejercicio17(){
        /*
        Calcular el factorial de un número entre 0 y 20. El factorial de un número se define del siguiente modo:
        F(0) = 1; F(1) = 1; F(n) = n(n-1)(n-2) ... 1 siendo n>1. (Factorial)
         */
        System.out.println("Introduce un numero del que quieras calcular su factorial");
        int numero = scanner.nextInt();
        int factorial = 1;
        if (numero<1){
            System.out.println("No puedo calcular su factorial");
        }else{
            for (int i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
            System.out.printf("El factorial del numero %d es %d",numero,factorial);
        }
    }


}




