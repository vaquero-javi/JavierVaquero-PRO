import java.util.Scanner;

public class Entrada_Switch {
    public static void main(String[] args) {
        int numero = 6;
        switch (numero){
            case 0:
                System.out.println("El valor es 0");
                break;
            case 5:
                System.out.println("El valor es 5");
                break;
            case 10:
                System.out.println("El valor es 10");
                break;
            default:
                System.out.println("El valor no esta contemplado");
        }
        System.out.println("Terminando bloque");


        //Ejercicio1();
        //Ejercicio2();
        //Ejercicio3();
        //Ejercicio4();
        //Ejercicio6();
        //Ejercicio7();
        //Ejercicio8();
        Ejercicio9();
    }
    public static void Ejercicio1(){
        /*
        Escribe un programa en Java que solicite al usuario ingresar un número del
        1 al 7 y muestre el día de la semana correspondiente utilizando una
        sentencia switch.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero del 1-7");
        int numero = scanner.nextInt();
        switch (numero){
            case 1:
                System.out.println("El valor es 1");
                break;
            case 2:
                System.out.println("El valor es 1");
                break;
            case 3:
                System.out.println("El valor es 1");
                break;
            case 4:
                System.out.println("El valor es 1");
                break;
            case 5:
                System.out.println("El valor es 1");
                break;
            case 6:
                System.out.println("El valor es 1");
                break;
            case 7:
                System.out.println("El valor es 1");
                break;
            default:
                System.out.println("No has puesto el valor correcto");
        }
    }
    public static void Ejercicio2(){
        /*
        Crea un programa que permita al usuario ingresar un carácter y luego
        determine si es una vocal o una consonante utilizando una sentencia switch.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame un carácter");
        char letra = scanner.next().charAt(0);
        switch (letra){
            case 'a' | 'e' | 'i' | 'o' | 'u':
                System.out.println("Es una vocal");
                break;
            default:
                System.out.println("Es una consonante");
        }
    }
    public static void Ejercicio3(){
        /*
        Desarrolla un programa que reciba un número entero y,
        utilizando una sentencia switch, determine si es par o impar.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int numero=scanner.nextInt();
        int resto = numero%2;
        switch (resto){
            case 0:
                System.out.println("Es par");
                break;
            default:
                System.out.println("Es impar");
        }
    }
    public static void Ejercicio4(){
        /*
        * Realiza un programa que solicite al usuario ingresar
        * un mes (como un número del 1 al 12) y muestre la cantidad
        * de días que tiene ese mes, considerando años no bisiestos.
        * */
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduce el mes con numero 1-12");
        int mes = scanner.nextInt();
        switch (mes){
            case 1 , 3 , 5 , 7 , 8 , 10 , 12:
                System.out.println("Tiene 31");
                break;
            case 2:
                System.out.println("Tiene 28");
                break;
            case 4 | 6 | 9 | 11:
                System.out.println("Tiene 30");
                break;
        }
    }
    public static void Ejercicio6(){
        /*
        * Crea un programa que permita al usuario ingresar un número del 1 al 4
        * y muestre un mensaje diferente para cada número utilizando una
        * sentencia switch (por ejemplo, "Opción 1 seleccionada", "Opción
        * 2 seleccionada", etc.).
        * */
        Scanner scanner =new Scanner(System.in);
        System.out.println("Introduce un numero del 1 al 4");
        int numero = scanner.nextInt();
        switch (numero){
            case 1:
                System.out.println("Opcion 1");
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            case 3:
                System.out.println("Opcion 3");
                break;
            case 4:
                System.out.println("Opcion 4");
                break;
            default:
                System.out.println("No has introducido un numero del 1 al 4");
        }
    }
    public static void Ejercicio7(){
        /*
        Desarrolla un programa que solicite al usuario ingresar una nota del
        1 al 5 y muestre un mensaje de calificación utilizando una sentencia
        switch (por ejemplo, "Suspenso", "Aprobado", "Notable", "Sobresaliente", etc.).
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una nota del 1-5");
        int numero= scanner.nextInt();
        switch (numero){
            case 1 , 2:
                System.out.println("Suspenso");
                break;
            case 3:
                System.out.println("Bien");
                break;
            case 4:
                System.out.println("Notable");
                break;
            case 5:
                System.out.println("Sobresaliente");
                break;
            default:
                System.out.println("No has introducido un numero del 1-5");
        }
    }
    public static void Ejercicio8(){
        /*
        Realiza un programa que pida al usuario ingresar un carácter que
        represente una operación matemática (+, -, *, /) y dos números.
        Luego, utiliza una sentencia switch para realizar la operación
        correspondiente y mostrar el resultado.
         */
        Scanner scanner =new Scanner(System.in);
        System.out.println("Introduce un operando(+ - * /)");
        char operando = scanner.next().charAt(0);
        System.out.println("Introduce un numero");
        int numero1 = scanner.nextInt();
        System.out.println("Introduce otro numero");
        int numero2 = scanner.nextInt();
        switch (operando){
            case '+':
                int suma=numero1+numero2;
                System.out.println("La suma da "+suma);
                break;
            case '-':
                int resta=numero1-numero2;
                System.out.println("La resta da "+resta);
                break;
            case '*':
                int multiplicacion=numero1*numero2;
                System.out.println("La multiplicacion da "+multiplicacion);
                break;
            case '/':
                int division=numero1/numero2;
                System.out.println("La division da "+division);
                break;
            default:
                System.out.println("No has introducido bien el operando");
        }
    }
    public static void Ejercicio9(){
        /*
        Escribe un programa que solicite al usuario ingresar un número del 1 al 12
        y muestre la estación del año correspondiente (por ejemplo, "Primavera",
        "Verano", "Otoño", "Invierno") utilizando una sentencia switch.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero del 1-12");
        int numero = scanner.nextInt();
        switch (numero){
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
            default:
                System.out.println("No has introducido bien el dato");
        }
    }
    public static void Ejercicio10(){
        /*
        Crea un programa que permita al usuario ingresar un código de producto
        (como una cadena de caracteres) y, utilizando una sentencia switch,
        muestre el nombre del producto y su precio correspondiente
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un codigo de producto");
        String producto = scanner.nextLine();
        switch (producto){
            case "Iphone":
                System.out.println("El Iphone cuesta 1000");
                break;
            case "Play 5":
                System.out.println("La play 5 cuesta 600");
                break;
        }
    }
}