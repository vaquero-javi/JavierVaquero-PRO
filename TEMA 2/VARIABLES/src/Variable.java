public class Variable {

    static int edadClase =50;

    //**//
    // public --> modificador de acceso
    // static --> modificador adicional
    // void -->modificador retorno
    // main --> nombre
    // (String[] args) --> (argumentos)
    // {} --> {cuerpo}
    public static void main (String[] args){
        System.out.println("Proyecto de variables");
        valoresMaximos();

        //Variable --> Tipo de nombre = valor (el valor es opcional)

        //Tipos de variables
        String nombre = "Javi";
        char letra ='A'; //variable simple
        Character letraCompleja = 'a'; //variable compleja

        byte numeroMuyPequenio = 1;
        Byte numeroMuyPequenioComplejo =1;

        short numeroPequeno = 23; //numero pequeño (-255, 255) //variable simple
        Short pequenioComplejo =23; //variable compleja


        //variable que cambia
        int edad = 22; //números sin decimal (-32.768, 32.767) //variable simple
        Integer edadCompleja =22; //variable compleja
        System.out.println("Mi edad es "+edad);
        edad = 23;
        System.out.println("Cambiando edad");
        System.out.println("Mi edad es "+edad);

        //variable que no cambia
        final String DNI = "09378459L"; //nombre de las final siempre en MAYUSCULAS

        long telefono = 635526107; //variable simple
        Long telefonoComplejo = 635526107L; //variable compleja

        float altura = 1.75f; //variable simple
        Float alturaCompleja = 1.75f; //variable compleja

        double decimalesDetalle = 3.1415643256; //variable simple
        Double decimalesDetalleCompleja = 3.1415643256; //variable compleja


        boolean carne = true; //variable simple
        boolean carne2 = false; //variable simple
        Boolean carneCompleja = false; //variable compleja
        Boolean carne2Compleja = false; //variable compleja

    }

    public static void miMetodo(){
        String nombre = "Javi";
        int edad = 22;
    }

    public static void otroMetodo(){

    }

    public static void valoresMaximos(){
        //esto sería con println
        System.out.println("Estos son los valores maximos y minimos de los tipos");
        System.out.println("El tipo byte tiene un maximo de "+Byte.MAX_VALUE+" y un valor minimo de "+Byte.MIN_VALUE );
        System.out.println("El tipo short tiene un maximo de "+Short.MAX_VALUE+" y un valor minimo de "+Short.MIN_VALUE );
        System.out.println("El tipo int tiene un maximo de "+Integer.MAX_VALUE+" y un valor minimo de "+Integer.MIN_VALUE );
        System.out.println("El tipo long tiene un maximo de "+Long.MAX_VALUE+" y un valor minimo de "+Long.MIN_VALUE );
        System.out.println("El tipo double tiene un maximo de "+Double.MAX_VALUE+" y un valor minimo de "+Double.MIN_VALUE );
        System.out.println("El tipo float tiene un maximo de "+Float.MAX_VALUE+" y un valor minimo de "+Float.MIN_VALUE );

        //esto sería con printf
        System.out.printf("Estos son los valores maximos y minimos de los tipos");
        System.out.printf("El tipo de byte tiene un maximo de %d y un valor minimo de %d", Byte.MAX_VALUE, Byte.MIN_VALUE);
        System.out.printf("El tipo de short tiene un maximo de %d y un valor minimo de %d", Short.MAX_VALUE, Short.MIN_VALUE);
        System.out.printf("El tipo de int tiene un maximo de %d y un valor minimo de %d", Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.printf("El tipo de long tiene un maximo de %d y un valor minimo de %d", Long.MAX_VALUE, Long.MIN_VALUE);
        System.out.printf("El tipo de double tiene un maximo de %.5f y un valor minimo de %.5f", Double.MAX_VALUE, Double.MIN_VALUE);
        System.out.printf("El tipo de float tiene un maximo de %f y un valor minimo de %f", Float.MAX_VALUE, Float.MIN_VALUE);

    }
}
