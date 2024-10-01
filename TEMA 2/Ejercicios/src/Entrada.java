import java.util.Scanner;

public class Entrada {
    static Scanner escribirTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
        //ejercicio5();
        //ejercicio6();
        //ejercicio7();
        //ejercicio8();
        //ejercicio9();
        //ejercicio10();
        //ejercicio11();
        ejercicio12();
        //ejercicio13();
        //ejercicio14();
        //ejercicio15();
    }
    public static void ejercicio1(){
    /*
    * Hágase un programa en el que se declare constantes locales con tu nombre completo,
    * la dirección de tu casa (sólo la calle), el número del portal, el piso, la letra del piso,
    * el código postal, la localidad, la provincia y el país. Muéstrese por consola dichos
    * datos almacenados en las constantes como si fuera la dirección a la que se enviaría
    * una carta. (Direccion)*/

        final String NOMBRECOMPLETO = "Javier Vaquero Vila";
        final String DIRECCIONCASA = "C/ Creta";
        final int NUMEROPORTAL = 7;
        final int PISO = 6;
        final char LETRA = 'b';
        final int CODIGOPOSTAL = 28943;
        final String LOCALIDAD = "Fuenlabrada";
        final String PROVINCIA = "Madrid";
        final String PAIS = "España";

        System.out.println(NOMBRECOMPLETO);
        System.out.printf("%s \tnª%d \t\t%d %c\n", DIRECCIONCASA, NUMEROPORTAL, PISO, LETRA);
        System.out.printf("%d \t\t%s %s\n", CODIGOPOSTAL, LOCALIDAD, PROVINCIA);
        System.out.println(PAIS);
    }
    public static void ejercicio2(){
        /*
        * Programa que lee el nombre completo y la edad de una persona,
        * y muestra los datos leídos. (leerNombreEdad)*/

        String nombreCompleto;
        int edad;
        System.out.println("ESCRIBE TU NOMBRE COMPLETO");
        nombreCompleto = escribirTeclado.nextLine();
        System.out.println("ESCRIBE TU EDAD");
        edad = escribirTeclado.nextInt();
        System.out.println("Te llamas "+nombreCompleto);
        System.out.println("Tienes "+edad+ " años");
    }
    public static void ejercicio3(){
        /*
        * Hágase un programa que lea dos variables enteras y obtenga
        * las siguientes operaciones:
        *   a) Suma
        *   b) Resta
        *   c) Multiplicación
        *   d) División entera
        *    e) Resto
        *   f) División real
        *   g) Resto real
        *   (Operaciones)*/

        System.out.println("Escribe un numero");
        int numero1 = escribirTeclado.nextInt();
        System.out.println("Escribe otro numero");
        int numero2 = escribirTeclado.nextInt();
        System.out.println("El numero 1 es "+numero1+ " y el numero 2 es "+numero2);
        int suma = numero1+numero2;
        System.out.println("SUMA " + suma);
        int resta = numero1-numero2;
        System.out.println("RESTA "+resta);
        int multiplicacion = numero1 * numero2;
        System.out.println("MULTIPLICACION "+multiplicacion);
        int divisionEntera = numero1 / numero2;
        System.out.println("DIVISION ENTERA "+divisionEntera);
        int restoEntera = numero1 % numero2;
        System.out.println("RESTO ENTERA "+restoEntera);
        float divisionReal = (float) numero1 / numero2;
        System.out.printf("DIVISION REAL %.2f\n", divisionReal);
        double restoReal = (double)numero1 % numero2;
        System.out.println("RESTO REAL "+restoReal);
    }
    public static void ejercicio4(){
    /*
    * Unos amigos entra en un bar que ofrece las bebidas a 1,25€ y los bocadillos a 2,05€.
    * El camarero les pregunta cuántas bébidas y bocadillos quieren. Calcula el
    * coste de la consumición, mostrando primero el coste de las bebidas
    * y de los bocadillos. (Bar)*/
        final float BEBIDAS = 1.25F;
        final float BOCADILLOS = 2.05F;
        System.out.println("¿Cuantas bebidas quereis?");
        int bebidaRespuesta = escribirTeclado.nextInt();
        System.out.println("¿Cuantos bocadillos quereis?");
        int bocadillosRespuesta = escribirTeclado.nextInt();
        System.out.println("Numero de bebidas "+bebidaRespuesta);
        System.out.println("Numero de bocadillos "+bocadillosRespuesta);
        float costeBebidas = BEBIDAS * bebidaRespuesta;
        System.out.printf("Coste de bebidas %.2f\n", costeBebidas);
        float costeBocadillos = BOCADILLOS * bocadillosRespuesta;
        System.out.printf("Coste de bocadillos %.2f\n", costeBocadillos);
        float costeTotal = costeBebidas + costeBocadillos;
        System.out.printf("Coste total %.2f\n", costeTotal);
    }
    public static void ejercicio5(){
        //Hágase un programa que convierta segundos en horas, minutos y segundos.(Segundos)
        System.out.println("Dime un numero de segundos");
        int numSegTot = escribirTeclado.nextInt();
        int horas = numSegTot/3600;
        int segundosRestantes = numSegTot % 3600;
        int minutos = segundosRestantes / 60;
        int segundos = segundosRestantes % 60;
        System.out.println("HORAS "+horas);
        System.out.println("MINUTOS "+minutos);
        System.out.println("SEGUNDOS "+segundos);
    }
    public static void ejercicio6(){
        /*Permítase introducir el valor con IVA de una compra con dos decimales
        (la compra no puede ser superior a 500€ ni inferior a 0€) y el valor del IVA de
        dicha compra (valor entero entre 0 y 25%).¿Cuánto costó la compra sin IVA?
        ¿Cuánto fue el IVA? Muéstrese los resultados redondeados a dos decimales.
        (Compra)
        * */
        System.out.println("Dime el valor de tu compra (0-500€)");
        float valorCompra = escribirTeclado.nextFloat();
        System.out.println("Dime el valor del IVA (0-25%)");
        int valorIva = escribirTeclado.nextInt();
        float ivaDeCompra = valorCompra * ((float)valorIva/100);
        float compraSinIva = valorCompra - ivaDeCompra;
        System.out.println("VALOR COMPRA SIN IVA "+ compraSinIva);
        System.out.println("VALOR DEL IVA "+ivaDeCompra);
        System.out.println("===========================");
        System.out.println(valorCompra);
    }
    public static void ejercicio7(){
        /*
        * Permítase introducir el valor del radio de una circuferencia con valores entre 0 y 100.
        * Obténgase la longitud de la circunferencia (2πr) y el área del circulo (πr2) .
        * (Circunferencia) NOTA El valor de PI se obtiene con Math.PI
        * */
        System.out.println("Introduce un valor entero del radio de la circunferencia (valores de 0-100)");
        int radio = escribirTeclado.nextInt();
        double longitudCircunferencia = 2 * Math.PI * radio;
        double areaCirculo = Math.PI * Math.pow(radio,2);
        System.out.printf("El valor del radio es: \t\t\t\t\t%d\n· La longitud de la circunferencia es: \t%f\n·" +
                " El area del circulo es: \t\t\t\t%f\n", radio,longitudCircunferencia,areaCirculo);
    }
    public static void ejercicio8(){
        /*
        * Hágase una aplicación que permita realizar conversiones de temperaturas entre grados centígrados,
        * farenheit y kelvin (los resultados se muestran redondeados a dos decimales).
        * (Temperaturas)
        * */
        System.out.println("Dame un dato de grados centrigrados");
        double gradosCentrigrados = escribirTeclado.nextFloat();
        double fahrenheit;
        double kelvin;
        //gradosCentrigrados=(5*(fahrenheit-32))/9;
        fahrenheit=(gradosCentrigrados*9+160)/5;
        //gradosCentrigrados=kelvin-273.15;
        kelvin= gradosCentrigrados+273.15;
        System.out.printf("Grados centigrados: %.2f\n Grados fahrenheit: %.2f\n Grados kelvin: %.2f\n",gradosCentrigrados,fahrenheit,kelvin);
        System.out.println("=============================");

        System.out.println("Dame un dato de grados fahrenheit");
        fahrenheit= escribirTeclado.nextFloat();
        //fahrenheit=((9*gradosCentrigrados)/5)+32;
        gradosCentrigrados=(fahrenheit*5+32)/9;
        //fahrenheit=(9*(kelvin-273.15)/5)+32;
        kelvin=(fahrenheit*5+2458.35-32)/9;
        System.out.printf("Grados fahrenheit: %.2f\n Grados centigrados: %.2f\n Grados kelvin: %.2f\n",fahrenheit,gradosCentrigrados,kelvin);
        System.out.println("=============================");

        System.out.println("Dame un dato de grados kelvin");
        kelvin=escribirTeclado.nextDouble();
        //kelvin=gradosCentrigrados+273.15;
        gradosCentrigrados=kelvin-273.15;
        //kelvin=(5*(fahrenheit´32)/9)+273.15;
        fahrenheit=(kelvin*9+160-273.5)/5;
        System.out.printf("Grados kelvin: %.2f\n Grados centigrados: %.2f\n Grados fahrenheit: %.2f\n",kelvin,gradosCentrigrados,fahrenheit);
    }
    public static void ejercicio9(){
        /*
        * Hágase una aplicación que permita introducir el número de bebidas y bocadillos comprados (valores entre 0 y 20). Además se podrá
        * introducir el precio de cada bebida (valor entre 0.00 € y 3.00 €) y de cada bocadillo (valor entre 0.00 € y 5.00 €).
        * También se podrá introducir el número de alumnos que realizaron la compra (valor entre 0 y 10). Se mostrará el total
        * de la compra (con el subtotal de las bebidas y de los bocadillos) y la cantidad que debe pagar cada alumno redondeada
        * a 2 decimales. (CosteBar)
        * */
        System.out.println("¿Cuantas bebidas quieres comprar?");
        int cantidadBebidas = escribirTeclado.nextInt();
        System.out.println("¿Cuantos bocadillos quieres comprar?");
        int cantidadBocadillos = escribirTeclado.nextInt();
        System.out.println("El precio de cada bebida es...");
        float precioBebida =escribirTeclado.nextFloat();
        System.out.println("El precio de cada bocadillo es...");
        float precioBocadillo =escribirTeclado.nextFloat();
        System.out.println("¿Cuantos alumnos sois?");
        int alumnos = escribirTeclado.nextInt();
        float costeBebidas = cantidadBebidas * precioBebida;
        float costeBocadillos = cantidadBocadillos * precioBocadillo;
        float costeTotal = costeBebidas + costeBocadillos;

        System.out.println("ARTICULO \t\tCANTIDAD \t\tPRECIO \t\tCOSTE");
        System.out.println("=============\t===========\t\t==========\t=========");
        System.out.printf("Bebida \t\t\t\t\t%d \t\t\t%.2f \t\t%.2f\n", cantidadBebidas,precioBebida,costeBebidas);
        System.out.printf("Bocadillo \t\t\t\t%d \t\t\t%.2f \t\t%.2f\n", cantidadBocadillos,precioBocadillo,costeBocadillos);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t==========");
        System.out.println("TOTAL \t\t\t\t\t\t\t\t\t\t\t "+costeTotal);
        System.out.println("-------------------------------------------------------------");
    }
    public static void ejercicio10(){
        /*
        * Se introducen los 5 dígitos de un número (decenas de mil, unidades de mil, centenas, decenas y unidades),
        * y se obtiene el número correspondiente. (Numero)
        * */
        System.out.println("Dame 5 digitos");
        int num1 = escribirTeclado.nextInt();
        int num2 = escribirTeclado.nextInt();
        int num3 = escribirTeclado.nextInt();
        int num4 = escribirTeclado.nextInt();
        int num5 = escribirTeclado.nextInt();
        System.out.println("Decenas de mil: "+num1);
        System.out.println("Unidades de mil: "+num2);
        System.out.println("Centenas: "+num3);
        System.out.println("Decenas: "+num4);
        System.out.println("Unidades: "+num5);
        System.out.printf("Numero introducido: %d%d%d%d%d",num1,num2,num3,num4,num5);
    }
    public static void ejercicio11(){
        /*
        * Hágase una aplicación que lea un entero entre 0 y 100. Compruébese (mostrándose verdadero o falso)
        * las siguientes condiciones:
        * a) Es par
        * b) Es mayor que 50
        * */
        System.out.println("Dame un numero entre el 0-100");
        int numero = escribirTeclado.nextInt();
        System.out.println("¿Es par?");
        boolean par = (numero % 2)==0;
        System.out.println(par);
        System.out.println("¿Es mayor de 50?");
        par = numero >=50;
        System.out.println(par);
    }
    public static void ejercicio12(){ //EN ESTE EJERCICIO TENGO PREGUNTAS!!!
        /*
        * 1. Hágase una aplicación que lea dos cadenas y las compare del siguiente modo:
        * a) Son iguales
        * b) La primera es menor que la segunda
        * c) Son distintas
        * */
        System.out.println("Dime una palabra");
        String palabra1 = escribirTeclado.nextLine();
        System.out.println("Dime otra palabra");
        String palabra2 = escribirTeclado.nextLine();
        System.out.println("¿Son iguales?"); //pongo la misma palabra en la maquina y me sale como false
        boolean comparar = palabra1.equals(palabra2);
        System.out.println(comparar);
        System.out.println("¿La primera es menor que la segunda?");
        comparar = palabra1.compareTo(palabra2)==0; //NO ENTIENDO COMO HAGO PARA PONER ESTO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(comparar);
        System.out.println("¿Son distintas?");
        comparar =palabra1  != palabra2;
        System.out.println(comparar);
    }
    public static void ejercicio13(){
        /*
        * 1. Lea dos números entre 0 y 9, ambos inclusive. Compruébese (mostrándose verdadero o falso) las siguientes condiciones e indíquese cómo se evalúan:
        * a) El primero es par y el segundo impar
        * b) El primero es superior al doble del segundo e inferior a 8
        * c) Son iguales o la diferencia entre el primero y el segundo es menor que 2
        * */
        System.out.println("Dime un numero entre 0-9");
        int num1 = escribirTeclado.nextInt();
        System.out.println("Dime otro numero entre 0-9");
        int num2 = escribirTeclado.nextInt();
        boolean par = num1 % 2 ==0;
        boolean impar = num2 %2 !=0;
        System.out.println("¿El primero es par y el segundo impar?");
        System.out.println(par && impar);

        System.out.println("¿El primero es superior al doble del segundo e inferior a 8?");
        par = num1 > 2*num2;
        impar = num1 < 8;
        System.out.println(par && impar);

        System.out.println("¿Son iguales o la diferencia entre el primero y el segundo es menor que 2?");
        par = num1 == num2;
        impar = num1-num2 < 2;
        System.out.println(par || impar);
    }
    public static void ejercicio14(){
        /*
        * Hágase una aplicación que permita introducir la edad de una persona (valores enteros entre 0 y 100),
        * su nivel de estudios (valores entre 0 y 10) y sus ingresos (valores enteros entre 0 y 25000).
        * Compruébese (mostrándose verdadero o falso) si dicha persona tiene más de 40 años, un nivel de
        * estudios entre 5 y 8, ambos incluisives, y gana menos de 15000 €. (CondicionLogica)
        * */
        System.out.println("Introduce tu edad (0-100)");
        int edad = escribirTeclado.nextInt();
        System.out.println("Intruduce tu nivel de estudios (0-10)");
        int estudios = escribirTeclado.nextInt();
        System.out.println("Introduce tus ingresos (0-25000)");
        int ingresos = escribirTeclado.nextInt();
        boolean compararEdad = edad > 40;
        boolean compararEstudios = estudios >= 5;
        boolean compararEstudios2 = estudios <= 8;
        boolean compararIngresos = ingresos < 15000;
        System.out.println("¿Tiene más de 40 años, un nivel de estudios entre 5 y 8, ambos incluisives, " +
                "y gana menos de 15000 €?");
        System.out.println(compararEdad && (compararEstudios || compararEstudios2) && compararIngresos);
    }
    public static void ejercicio15(){
        /*
        * 1. Se lee un entero que se modifica de la siguiente manera:
        * a) Incrementar en 5 unidades (+=5).
        * b) Decrementar en 3 unidades(-=3).
        * c) Multiplicar por 10 (*=10)
        * d) Dividir por 2 (/=2)
        * e) Mostrar dicho entero en cada uno de los apartados anteriores.
        * */
        System.out.println("Introduce un numero");
        int num = escribirTeclado.nextInt();

        System.out.println("Se incrementa 5 unidades al numero");
        num+=5;
        System.out.println(num);

        System.out.println("Se decrementa en 3 unidades");
        num-=3;
        System.out.println(num);

        System.out.println("Se multiplica por 10");
        num*=10;
        System.out.println(num);

        System.out.println("Se divide entre 2");
        num/=2;
        System.out.println(num);
    }
}
