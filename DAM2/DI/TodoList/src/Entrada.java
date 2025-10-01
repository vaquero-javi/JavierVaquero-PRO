import model.*;

import java.util.ArrayList;
import java.util.Calendar;
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
        TareaProfesional tareaProfesional = new TareaProfesional();
        Planificador planificador = new Planificador();

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ PLANIFICADOR ---");
            System.out.println("1. Registrar tarea");
            System.out.println("2. Modificar tarea");
            System.out.println("3. Listar todas las tareas");
            System.out.println("4. Completar tarea");
            System.out.println("5. Listar tareas completas");
            System.out.println("6. Listar tareas incompletas");
            System.out.println("7. Agregar responsable");
            System.out.println("8. Agregar encargo");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Tipo de tarea (1=Personal, 2=Profesional, 3=Generica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Prioritario (true/false): ");
                    boolean prioritario = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Número de personas: ");
                    int numPersonas = scanner.nextInt();
                    scanner.nextLine();

                    Tarea tarea = null;

                    if (tipo == 1) {
                        System.out.print("Ubicación: ");
                        String ubicacion = scanner.nextLine();
                        tarea = new TareaPersonal(titulo, descripcion, prioritario, numPersonas, ubicacion);
                    } else if (tipo == 2) {
                        System.out.print("Presupuesto: ");
                        int presupuesto = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Fecha límite (yyyy-mm-dd): ");
                        String fecha = scanner.nextLine();
                        Date fechaLimite = new Date(); // Temporal, podrías parsear el string
                        tarea = new TareaProfesional(titulo, descripcion, numPersonas, presupuesto, fechaLimite);
                    } else if (tipo == 3) {
                        System.out.print("Dato adicional: ");
                        String dato = scanner.nextLine();
                        tarea = new TareaGenerica(titulo, descripcion, prioritario, numPersonas, dato);
                    }

                    if (tarea != null) {
                        planificador.agregarTarea(tarea);
                    }
                    break;

                case 2:
                    System.out.print("ID de la tarea a modificar: ");
                    int idMod = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nuevo título (o ENTER para no modificar): ");
                    String nuevoTitulo = scanner.nextLine();
                    if (nuevoTitulo.isEmpty()) nuevoTitulo = null;

                    System.out.print("Nueva descripción (o ENTER para no modificar): ");
                    String nuevaDesc = scanner.nextLine();
                    if (nuevaDesc.isEmpty()) nuevaDesc = null;

                    System.out.print("Cambiar prioridad (true/false o ENTER para no modificar): ");
                    String priStr = scanner.nextLine();
                    Boolean nuevaPrioridad = null;
                    if (!priStr.isEmpty()) nuevaPrioridad = Boolean.parseBoolean(priStr);

                    planificador.modificarTarea(idMod, nuevoTitulo, nuevaDesc, nuevaPrioridad);
                    break;

                case 3:
                    planificador.listarTareas();
                    break;

                case 4:
                    System.out.print("ID de la tarea a completar: ");
                    int idComp = scanner.nextInt();
                    scanner.nextLine();
                    planificador.completarTarea(idComp);
                    break;

                case 5:
                    planificador.listarCompletas();
                    break;

                case 6:
                    planificador.listarIncompletas();
                    break;

                case 7:
                    System.out.print("ID de la tarea para agregar responsable: ");
                    int idResp = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    Persona p = new Persona(dni, nombre, edad, apellido);
                    planificador.agregarResponsable(idResp, p);
                    break;

                case 8:
                    System.out.print("ID de la tarea para agregar encargo: ");
                    int idEnc = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("ID del encargo: ");
                    int encId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Descripción del encargo: ");
                    String encDesc = scanner.nextLine();

                    Encargo e = new Encargo(encId, encDesc);
                    planificador.agregarEncargo(idEnc, e);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);


    }
}
