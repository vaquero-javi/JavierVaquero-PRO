package model;

public class TareaPersonal extends Tarea{

    @Override
    public void enviarRecordatorio() {
        System.out.println("Enviar un recordatorio para reservar" +
                "sitio en "+ubicacion);
    }

    private String ubicacion;

    public TareaPersonal(){

    }

    public TareaPersonal(String titulo, String descripcion, boolean prioritario, int numPersonas, String ubicacion){
        super(titulo,descripcion,prioritario,numPersonas);
        this.ubicacion = ubicacion;
    }

    public TareaPersonal(String titulo, String descripcion, int numPersonas, String ubicacion){
        super(titulo,descripcion,numPersonas);
        this.ubicacion = ubicacion;
    }

    public void mostrarDatos(){

    }

    @Override
    public String toString() {
        return super.toString()+ "TareaPersonal{" +
                "ubicacion='" + ubicacion + '\'' +
                '}';
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
