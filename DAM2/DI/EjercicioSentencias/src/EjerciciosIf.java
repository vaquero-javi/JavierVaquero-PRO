import java.util.Scanner;

public class EjerciciosIf {
    Scanner scanner = new Scanner(System.in);

    //Lee dos enteros y muestra si el primero es mayor que el segundo.
    public void comparaDosEnteros(){
        System.out.println("1.Lee dos enteros y muestra si el primero es mayor que el segundo.");
        int a ;
        int b ;
        System.out.println("Introduce un número");
        a = scanner.nextInt();
        System.out.println("Introduce otro número");
        b = scanner.nextInt();

        if (a > b) {
            System.out.printf("El numero %d es mayor que el numero %d", a, b);
        } else if (a < b) {
            System.out.printf("El número %d es menor que el número %d", a, b);
        } else if (a == b) {
            System.out.printf("Los números %d y %s son iguales", a, b);
        }

    }

    //Lee un entero y comprueba si es múltiplo de 20 y si está entre -100 y 100.
    // Muestra uno de los cuatro mensajes posibles.
    public void multiploYrango(){
        System.out.println("2.Lee un entero y comprueba si es múltiplo de 20 y si está entre -100 y 100." +
                "Muestra uno de los cuatro mensajes posibles.");

        System.out.println("introduce un número");
        int a =scanner.nextInt();
        boolean multiplo = a % 20 == 0;
        boolean rango = a >= -100 && a <= 100;
        if (multiplo && rango) {
            System.out.println("El número " +a+ "SI es múltiplo de 20 y SI esta entre -100 y 100");
        } else if (multiplo) {
            System.out.println("El número " +a+ "SI es múltiplo de 20 pero NO está entre el -100 y 100");
        } else if (rango) {
            System.out.println("El número " +a+ "NO es múltiplo de 20 pero SI está entre el -100 y 100");
        } else {
            System.out.println("El número " +a+ "NO es múltiplo de 20 y NO está entre el -100 y 100");
        }
    }

    //Determina si un número natural de 4 dígitos es capicúa. Si no tiene 4 dígitos, indícalo.
    public void capicua(){
        System.out.println("3.Determina si un número natural de 4 dígitos es capicúa. Si no tiene 4 dígitos, indícalo.");

        System.out.println("Introduce un numero de 4 dígitos");
        int a = scanner.nextInt();

        if (a<1000 || a>9999){
            System.out.println("No has escrito un número de 4 digitos");
        }

        int unidad = a % 10 ;
        int decena = (a / 10) % 10;
        int centena = (a / 100) % 10;
        int millar = a / 1000;
        if (unidad == millar && decena == centena){
            System.out.println("Este número SI es capicúa");
        }else {
            System.out.println("Este número NO es capicúa");
        }

    }

    //Lee un entero. Si es par, incrementa en 1; si es impar, decrementa en 1. Muestra el nuevo valor.
    public void incrementoYdecremento(){
        System.out.println("4.Lee un entero. Si es par, incrementa en 1; si es impar, decrementa en 1. " +
                "Muestra el nuevo valor.");

        System.out.println("Introduce un número entero");
        int a = scanner.nextInt();
        boolean par = a % 2 == 0;
        if (par){
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a+1));
        }else {
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a-1));
        }
    }

    //Lee un entero y aplica: +2 si es par, +3 si es múltiplo de 3, +5 si es múltiplo de 5; si no cumple ninguna, +1.
    public void incrementoXcondicionales(){
        System.out.println("5.Lee un entero y aplica: +2 si es par, +3 si es múltiplo de 3, +5 si es múltiplo de 5; " +
                "si no cumple ninguna, +1.");

        System.out.println("Introduce un numero");
        int a = scanner.nextInt();
        boolean par = a % 2 == 0;
        boolean multiplo3 = a % 3 == 0;
        boolean multiplo5 = a % 5 == 0;

        if (par) {
            System.out.println("ES PAR, LE SUMAMOS 2");
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a+2));
        } else if (multiplo3) {
            System.out.println("ES MULTIPLO DE 3, LE SUMAMOS 3");
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a+3));
        } else if (multiplo5) {
            System.out.println("ES MULTIPLO DE 5, LE SUMAMOS 5");
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a+5));
        }else {
            System.out.println("NO CUMPLE NINGUNA CONDICIÓN, LE SUMAMOS 1");
            System.out.println("Entrada " + a);
            System.out.println("Salida " + (a+1));
        }
    }

    //Pide día, mes y año e indica si la fecha es correcta considerando meses de 28, 30 y 31 días. Sin años bisiestos.
    public void validarFecha(){
        System.out.println("6.Pide día, mes y año e indica si la fecha es correcta considerando meses de 28, 30 y 31" +
                " días. Sin años bisiestos.");

        System.out.println("Introduce un dia de forma numérica");
        int dia = scanner.nextInt();
        System.out.println("Introduce un mes de forma numérica");
        int mes = scanner.nextInt();
        System.out.println("Introduce un año de forma numérica");
        int anio = scanner.nextInt();

        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes ==8 || mes ==10 || mes ==12) &&
                (dia > 0 && dia <=31)) {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha correcta");
        }else {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha incorrecta");
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 0 && dia <=30)) {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha correcta");
        }else {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha incorrecta");
        }


        if (mes == 2 && (dia > 0 && dia <=28)) {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha correcta");
        }else {
            System.out.println("Entrada: " + dia+ "/" +mes+ "/" +anio);
            System.out.println("Salida: Fecha incorrecta");
        }




    }
}

