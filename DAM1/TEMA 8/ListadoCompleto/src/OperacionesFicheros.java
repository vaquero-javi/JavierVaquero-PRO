import java.io.File;

public class OperacionesFicheros {

    public void leerFicheros() {
        File file = new File("C:\\Users\\javie\\OneDrive\\Documentos\\GitHub\\JavierVaquero-PRO");
        File[] archivos = file.listFiles();

        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                System.out.println("DIRECTORIO: " + file.getName());
                System.out.println("ARCHIVO: " + archivo.getName());
            } else {
                System.out.println("ARCHIVO: " + archivo.getName());
            }
        }

    }
}
