package model;

public class Tarea {

    //una tarea tiene una serie de personas
    //cuando se crea la tarea es necesario pedir
    // cuantas personas encargaran la tarea


    //cada tarea puede asignar una persona
    //solo se podrá asignar una persona si hay hueco disponible
    //cada vez que se asigne una persona,se deberá colocar en el primer hueco disponible
    //si no hay hueco saltar un aviso
    //No podras agregar dos personas con el mismo dni


    //En una tarea se pueden quitar responsables. Solo podré quitar una tarea solo si el DNI
    //que me indicas esta dentro de la lista de responsables. Mostrar aviso tanto para proceso OK
    //como proceso no OK


    //Mostrar los datos de todos los usuarios que son responsables de dicha tarea
    //en caso de no tener ninguna avisar
    //en caso de tener huecos disponibles decir cuantos


    //variables
    private String titulo, descripcion;
    private boolean prioritario, completada;
    private Persona[] encargados;

    //contructores
    public Tarea(){

    }
    public Tarea(String titulo, String descripcion, boolean prioritario, int numPersonas){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioritario = prioritario;
        encargados = new Persona[numPersonas];
    }
    public Tarea(String titulo, String descripcion, int numPersonas){
        this.titulo = titulo;
        this.descripcion = descripcion;
        encargados = new Persona[numPersonas];
    }
    //metodos -> getter / setter

    public void asignarResponsable(Persona persona){
        for (int i = 0; i < encargados.length; i++) {

            if (encargados[i] == null && !estaDNI(persona.getDni())) {
                encargados[i] = persona;
                System.out.println("Persona agregada correctamente");
                return;
            }
        }
        System.out.println("No hay hueco disponible, tarea completa");
    }

    private boolean estaDNI(String dni){
        for (Persona persona : encargados){
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }

    public boolean eliminarResponsable(String dni){
        for (Persona persona : encargados){
            if (persona != null && persona.getDni().equalsIgnoreCase(dni)){
                persona = null;
                System.out.println("Persona eliminada correctamente");
                return true;
            }
        }
        System.out.printf("La perdona con DNI %s no está en esta tarea %n ",dni);
        return false;
    }

    public void mostarUsuarios(){
        int contadorNoHayPersonas = 0;
        int contadorSiHayPersonas = 0;
        for (Persona persona : encargados){
            if (persona == null){
                contadorNoHayPersonas++;
            }else {
                System.out.println(persona);
                contadorSiHayPersonas++;
            }
        }
        if (contadorNoHayPersonas == 0){
            System.out.println("No hay ninguna persona en la tarea");
        }else {
            System.out.println("Hay "+ contadorSiHayPersonas + "en la tarea");
            System.out.println("No hay "+ contadorNoHayPersonas + "en la tarea");
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioritario=" + prioritario +
                ", completada=" + completada +
                '}';
    }
}
