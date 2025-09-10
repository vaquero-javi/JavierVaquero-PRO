import java.io.*;

public class OperacionDescifrado {
    public void conversionASCIILetra(File file){

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int linea;
            while ((linea = bufferedReader.read())>-1){
                System.out.println(linea);
                System.out.println(Character.toChars(linea));
            }
        } catch (FileNotFoundException e) {
            System.out.println("error, no se ha encontrado");;
        } catch (IOException | NullPointerException e) {
            System.out.println("error de e/s de datos");;
        }finally {

        }
    }

}
