import model.Persona;
import model.Tarea;

public class Entrada {
    public static void main(String[] args) {
        Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa TODOList",
                true,
                6);
        tarea.asignarResponsable(new Persona("123456A","Javi",23,"Vaquero"));
        tarea.asignarResponsable(new Persona("123456B","Aitor",21,"Vaquero"));

    }
}
