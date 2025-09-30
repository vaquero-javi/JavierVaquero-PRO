package model;

import java.util.Date;

public class TareaProfesional extends Tarea{

    private int presupuesto;
    private Date fechaLimite;

    public TareaProfesional(){

    }

    @Override
    public void enviarRecordatorio() {
        // se imprime por consola, a cada uno de los responbles
        // el mensaje. Borja, recuerda terminar las tareas
        // asociadas a esta tarea. Borja, recuerda terminar
        // las tareas asociadas a esta tarea
        for (Persona persona: getEncargados()){
            if (persona != null) {
                System.out.printf("%s recuerda que completar %d tareas pendientes\n",
                        persona.getNombre(), getListaTareas().size());
            }

        }
    }

    public TareaProfesional(String titulo, String descripcion, int numPersonas, int presupuesto, Date fechaLimite){
        super(titulo,descripcion,numPersonas);
        this.fechaLimite;
        this.presupuesto;
    }

    @Override
    public String toString() {  //para sacar la informacion por consola de padre y de esta
        return super.toString()+ "TareaProfesional{" +
                "presupuesto=" + presupuesto +
                ", fechaLimite=" + fechaLimite +
                '}';
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
}
