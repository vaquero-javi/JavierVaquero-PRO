import java.io.File;
import java.io.IOException;

public class Operaciones {

    public void divisionEntre0(int numero) throws ArithmeticException{
        System.out.println("Dividimos un numero entre 0");
        System.out.println("La division del numero es "+numero/0);
    }

    public void crearFichero(String path) throws IOException {
        File file = new File(path);
            file.createNewFile();
    }

    public void lanzarExcepcion(String nombre) throws Exception{
        if (nombre.equalsIgnoreCase("error")){
            //lanzar una excepion
            throw new Exception("Error personalizado");
        }else {
            System.out.println("No hay error");
        }
    }
}
