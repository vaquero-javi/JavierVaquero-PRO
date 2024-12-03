public class Ejemplos {
    public static void main(String[] args) {

        //dando su posicion
        int[] numeros = new int[4];
        //0 0 0 0
        //cuantas posiciones tienes
        System.out.println("La longitud es "+numeros.length);
        //0 0 0 7
        numeros[3] = 7;
        System.out.println("El numero de laultima posicion es "+numeros[3]);

        //dando los datos
        String[] palabras = {"Hola", "Que", "Tal", "Estas"};
        System.out.println("La palabra en la ultima posicion es "+palabras[palabras.length-1]);


        //sacar todas las palabras que estan en al array
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("La palabras es "+palabras[i]);
        }

        //recorrer una coleccion, donde indico principio y final
        for (int i = 0; i < numeros.length; i++) {
            //los numeros que son pares
            if (numeros[i]%2==0) {
                System.out.println(numeros[i]);
            }
        }

        //ESTO ES UN FOREACH
        for (int item : numeros){
            System.out.println(item);
        }

    }
}
