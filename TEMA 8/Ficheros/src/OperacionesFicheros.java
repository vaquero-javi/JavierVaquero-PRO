import java.io.File;
import java.io.IOException;

public class OperacionesFicheros {

    public void leerInformacion(){
        File file = new File("C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO\\TEMA 8\\Ficheros\\src\\recursos\\ejemplo.txt");
        System.out.println(file.isFile());
        System.out.println(file.exists());
        file.list(); //nombre de los ficheros que están dentro
        for (String nombre : file.list()){
            System.out.println(nombre);
        }
        file.listFiles(); //Los ficheros que están dentro
        for (File fichero : file.listFiles()){
            System.out.println(fichero.getAbsoluteFile());
        }

    }

    public void crearDirectorio (String path){
        //src / recursos /lectura
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
    }

    public void crearFicheros (String path){
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("fallo en la escritura del fichero");
            }
        }
    }

    public void
}
