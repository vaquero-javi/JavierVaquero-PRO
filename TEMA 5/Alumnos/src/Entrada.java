import model.Alumno;
import model.Asignatura;
import model.Profesor;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        Asignatura programacion = new Asignatura(1);
        Asignatura sistemas = new Asignatura(2);
        Asignatura lenguaje = new Asignatura(3);


        Alumno borja = new Alumno(asignaturas.get(0).getIdentificador(),2,3);
        Alumno javi = new Alumno(1, 2, 3);

        Profesor profesor = new Profesor();
        profesor.ponerNotas(borja);
        profesor.ponerNotas(javi);
        System.out.println("La nota de la asignatura programacion es "+borja.getAsignatura1().getCalificacion());
        System.out.println("La nota de la asignatura sistemas es "+borja.getAsignatura2().getCalificacion());
        System.out.println("La nota de la asignatura lenguaje es "+borja.getAsignatura3().getCalificacion());

        System.out.println("La nota de la asignatura programacion es "+javi.getAsignatura1().getCalificacion());
        System.out.println("La nota de la asignatura sistemas es "+javi.getAsignatura2().getCalificacion());
        System.out.println("La nota de la asignatura lenguaje es "+javi.getAsignatura3().getCalificacion());

        System.out.println("La media del alumno es "+profesor.calcularMedia(borja));
    }

}

