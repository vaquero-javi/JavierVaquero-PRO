import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Entrada {
    public static void main(String[] args) {
        //escritura
        File ficherosAlumnos = new File("C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\TEMA 9\\repaso\\src\\main\\java\\resources\\alunnos.txt");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(ficherosAlumnos);
        } catch (IOException e) {
            System.out.println("error al encontrar el fichero");
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
