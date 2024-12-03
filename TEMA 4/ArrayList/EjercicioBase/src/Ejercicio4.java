import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Ejercicio4 {
    /*
    Crea un programa que cree un ArrayList de palabras, introduce en él 10 palabras cualquiera.
    Muestra el número de letras de todas las palabras, la palabra con más letras y la palabra con menos letra
     */


    private static ArrayList<String> listaPalabras = new ArrayList<>();

    public static void main(String[] args) {
        listaPalabras.add("Ejemplo1");
        listaPalabras.add("a1");
        listaPalabras.add("asd");
        listaPalabras.add("fdsafsa");
        listaPalabras.add("afda");
        listaPalabras.add("hsfsbhgsjhbhj");
        int numeroLetras=0;
        String palabraMayor = listaPalabras.get(0);
        String palabraMenor = listaPalabras.get(0);

        for (String item : listaPalabras){
            numeroLetras += item.length();
            if (palabraMayor.length()<item.length()){
                palabraMayor = item;
            }
            if (palabraMenor.length()>item.length()){
                palabraMenor = item;
            }
        }

        ordenarLista(listaPalabras);
    }
    public static void ordenarLista (ArrayList<String>lista){
        //Collections.sort(lista); //ordenados alfabeticamente
        Collections.sort(lista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                } else if (o1.length()<o2.length()) {
                    return -1;
                }else {
                return 0;
                }

            }
        });
    }
}
