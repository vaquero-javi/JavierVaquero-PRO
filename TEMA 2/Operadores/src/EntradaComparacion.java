public class EntradaComparacion {
    public static void main (String[] args){
        int n1 = 40;
        int n2 = 30;

        //OPERADORES DE COMPARACION
        System.out.println("Operadores de comparacion");
            // >
        boolean resultado = n1 > n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // >=
        resultado = n1 >= n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // <
        resultado = n1 < n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // >=
        resultado = n1 <= n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // ==
        n1=30;
        n2=20;
        resultado = n1 == n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // !=  diferente
        resultado = n1 != n2;
        System.out.println("El resultado de la comparacion es "+resultado);

            // !  negacion
        resultado = !resultado;


        //OPERADORES LOGICOS
        System.out.println("Operadores logicos");

        // && AND
        // || OR

        n1 = 30;
        n2 = 40;
        boolean n3=true;
        int n4 = -20;

            // &&
        boolean resultadoLogico = n1 < n2 && n3 && n4 < 0; //true && true && true = true
        System.out.println("El resultado logico de las && es "+resultadoLogico);

            // ||
        resultadoLogico = n1<0 || n2!=n4 || n3 || n4>0; //true || true || true || true || false= true
        System.out.println("El resultado logico de las || es "+resultadoLogico);

        boolean resultadoCompuesto;
        System.out.println("Ahora vamos a hacer && y || a la vez");
        resultadoCompuesto = ((n1>n2)&& !n3 && (n4<10)) || n4>0 || n2>0;
                            // (F && F && F) || F || T
                            // F || F || T
                            // T
        System.out.println("El resultado logico de las && y || es "+resultadoCompuesto);


        //COMPARAR PALABRAS

        // .equals sirve para comparar palabras
        // .equalsIgnoreCase sirve para comparar palabras si quieres ignorar mayusculas
        System.out.println("Ahora vamos a comparar palabras");

        String palabra1 = "hola";
        String palabra2 = "hola";
        boolean resultadoPalabras = palabra1.equals(palabra2);
        System.out.println("El resultado de la comparacion de las palabras es "+resultadoPalabras);


        //CASTING es implicito (tipo->tipo)
        //PARSEO : es forzado

        //Sirve para cambiar cosas temporalmente, por ejemplo cambiar un numero entero a un numero decimal

        //CASTEO O CASTING
        n1 = 4;
        n2 = 3;
        double resultadoOperacion = (double) n1/n2;
        System.out.println("El resultado de la division es "+resultadoOperacion);
        double resultadoOperacion =c(double) n1/n2; //Esto serviria para hacer un casteo pero de forma permanente

        //PARSEO
        String n1String = String.valueOf(n1); //Esto es para cualquier cosa a String
        String palabra = "1234";
        int numeroPalabra = Integer.parseInt(palabra); //Esto es para hacer un parseo de una palabra a un int

    }
}
