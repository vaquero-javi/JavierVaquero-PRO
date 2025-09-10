import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Entrada {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Integer> listaNumeros = new ArrayList();
    private static ArrayList<String>  listaPalabras = new ArrayList();

    public static void main(String[] args) {

        System.out.println("Utilizando listas");
        System.out.println("El tamaño inicial de la lista es: "+listaNumeros.size());


        System.out.println("Introduce un numero");
        anadirNumero(scanner.nextInt());
        System.out.println("Introduce un numero");
        anadirNumero(scanner.nextInt());
        System.out.println("Introduce un numero");
        anadirNumero(scanner.nextInt());
        System.out.println("Introduce un numero");
        anadirNumero(scanner.nextInt());

        anadirPalabra("palabra 1");
        anadirPalabra("palabra 2");
        anadirPalabra("palabra 3");
        anadirPalabra("palabra 4");
        borrarPalabra("palabra 1");
    }

    //PEDIR AL USUARIO UN NUMERO A AÑADIR:
    //AÑADIRLO A LA LISTA (AÑADIR 4 NUMEROS)
    // SI EL NUMERO YA ESTÁ EN LA LISTA, PEDIR CONFIRMACION.
    // SI NO ESTÁ EN LA LISTA AGREGARLO


    public static void anadirNumero(int numero){
        if (listaNumeros.contains(numero)){
            System.out.println("El numero está dentro de la lista ¿Seguro que quieres meterlo?");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("y")){
                listaNumeros.add(numero);
                System.out.println("Numero añadido correctamente");
                System.out.println("Lista actualizada con un size de: "+listaNumeros.size());
            }else {
            System.out.println("Saliendo de añadir");
            }
        }else {
        listaNumeros.add(numero);
        System.out.println("Numero añadido correctamente");
        System.out.println("Lista actualizada con un size de: "+listaNumeros.size());
        }
    }

    // TODO cambiar el retorno al indice donde esta el repetido
    public static int encontrarNumero (int numero){
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) == numero){
                return i;
            }
        }
        return -1;
    }

    public static void obtenerDatos(){
        System.out.println("El último elemento del arrayList es "+listaNumeros.get(listaNumeros.size()-1));
        System.out.println("Todos los elementos del arrayList son: ");
        for (int item : listaNumeros){
            System.out.println(item);
        }

    }

    public static void anadirPalabra(String palabra){
        listaPalabras.add(palabra);
    }

    public static void borrarPalabra(String palabra){
        listaPalabras.remove(palabra);

        listaPalabras.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                /*if (s.contains("5")){
                    return true
                }else {
                return false;
                }
                 */
                return s.contains("5");
            }
        });
    }






}
