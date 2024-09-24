public class Entrada {
    public static void main(String[]args){
        //OPERADORES ARITMETICOS

            //BINARIOS

                //SUMA
                int operador1 = 10;
                int operador2 = 5;
                int resultado = operador1 + operador2; //15
                System.out.println("El resultado de la suma es "+resultado);

                //RESTA
                resultado = operador1 - operador2; //5
                System.out.println("El resultado de la resta es "+resultado);

                //MULTIPLICACION
                resultado = operador1 * operador2; //50
                System.out.println("El resultado de la multiplicacion es "+resultado);

                //DIVISION
                operador1 = 7;
                operador2 =4;
                resultado = operador1 / operador2; //1
                System.out.println("El resultado de la division es "+resultado);

                //MODULO (el resto de la division)
                resultado = operador1 % operador2; //3.0
                System.out.println("El resultado del resto es "+resultado);


            //MONARIOS

                //OPUESTO
                resultado = -resultado; //-3
                System.out.println("El resultado del opuesto es "+resultado);

                //INCREMENTADOR
                //resultado = resultado + 1
                resultado = ++resultado; //-2
                System.out.println("El resultado del incremento es "+resultado);

                //DECREMENTO
                //resultado = resultado -1
                resultado = --resultado; //-3
                System.out.println("El resultado del decremento es "+resultado);


        //OPERADORES DE ASIGNACION
        System.out.println("OPERADORES DE ASIGNACION");
        resultado = 1;

            // +=
                operador1 = 10;
                resultado += operador1; //11
                System.out.println("El resultado de la suma asignada es "+resultado);

            // -=
                resultado -= 6; //5
                System.out.println("El resultado de la resta asignada es "+resultado);

            // *=
                resultado *= 3; //15
                System.out.println("El resultado de la multiplicacion asignada es "+resultado);

            // */=
                resultado /= 2; //7
                System.out.println("El resultado de la division asignada es "+resultado);

            // %=
                resultado /= 2; //3
                System.out.println("El resultado del modulo asignado es "+resultado);

    }
}
