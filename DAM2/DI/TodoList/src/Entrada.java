import model.Persona;
import model.Tarea;
import model.TareaPersonal;
import model.TareaProfesional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Tarea tarea = new Tarea("Practica DI",
                "Esta practica de DI es hacer un programa TODOList",
                true,
                6);

         */
        //tarea.asignarResponsable(new Persona("123456A","Javi",23,"Vaquero"));
        //tarea.asignarResponsable(new Persona("123456B","Aitor",21,"Vaquero"));
        //tarea.getListaTareas().size();
        /*
        TareaProfesional tareaProfesional=new TareaProfesional("TareaP1","descripcion",
                5,20, new Date());
        tareaProfesional.asignarResponsable(new Persona("123456A","Javi","Vaquero",23));
        tareaProfesional.asignarResponsable(new Persona("123456B","Aitor","Vaquero",20));
        TareaPersonal tareaPersonal = new TareaPersonal("TareaP2","descripcion",
                5,"Alcorcon");

        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(tareaPersonal);
        tareas.add(tareaProfesional);
        for (Tarea tarea1: tareas){
            System.out.println(tarea1);
        }

 */

        int opcion = 0;
        do {
            System.out.println("1.Registrar tarea");
            System.out.println("2.Modificar tarea");
            System.out.println("3.Listar tareas");
            System.out.println("4.Complementar tareas");
            System.out.println("5.Listar completas");
            System.out.println("6.Listar inclimpletas");
            switch (opcion){
                case 1:
                    System.out.println("Que quieres registrar?" +
                            " 1.Tarea profesional \n 2.Tarea personal");
                    int registro = scanner.nextInt();
                    if (registro = 1){
                        System.out.println("Introduce un titulo");
                        String titulo = scanner.nextLine();
                        System.out.println("Introduce un descripcion");
                        String descripcion = scanner.nextLine();
                        System.out.println("Introduce el numero de personas");
                        int numPersonas = scanner.nextInt();
                        System.out.println("Introduce el presupuesto");
                        int presupuesto = scanner.nextInt();
                        System.out.println("Introduce la fecha (dd/mm/yyyy)");
                        String fecha = scanner.nextLine();
                        int dia = Integer.parseInt(fecha.split("/")[0]);
                        int mes = Integer.parseInt(fecha.split("/")[1]);
                        int anio = Integer.parseInt(fecha.split("/")[2]);
                        TareaProfesional tareaProfesional = new TareaProfesional(titulo,descripcion,numPersonas,
                                presupuesto,)
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }
        }while (opcion!=7);


    }
}
