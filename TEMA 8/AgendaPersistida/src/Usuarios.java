import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Usuarios {
    public void datosUsuarios(String nombre, String apellido, String correo, int telefono, String path){
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            for (int i = 0; i < 5; i++) {
                System.out.println("nombre = " + nombre);
                System.out.println("apellido = " + apellido);
                System.out.println("correo = " + correo);
                System.out.println("telefono = " + telefono);
            }

        } catch (IOException e) {
            System.out.println("Error de entrada / salida");
        }finally {
            try {
                fileWriter.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }
}
