import utils.LetraException;
import utils.LongitudException;

public class Formulario {

    private String nombre;
    private String apellido;
    private String DNI;

    public void mostrarDatos(){
        if (nombre == null || apellido==null || DNI==null){
            throw  new NullPointerException("Alguno de los datos no esta relleno");
        }else {
            System.out.println("nombre = " + nombre);
            System.out.println("apellido = " + apellido);
            System.out.println("DNI = " + DNI);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre ==  null){
            throw new LongitudException("El nombre introducido no es válido");
        }

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null ){
            throw new LongitudException("El apellido no es valido");
        }
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws LetraException,LongitudException{
        char ultimaLetra = DNI.charAt(DNI.length()-1);
        // si ultima letra no es una letra
        if (Character.isDigit(ultimaLetra)){
            //da error
            throw new LetraException("El ultimo digito no es una letra");
        }
        if (DNI.length() != 9){
            throw new LongitudException("El tamaño del DNI no es correcto");
        }
        this.DNI = DNI;
    }
}
