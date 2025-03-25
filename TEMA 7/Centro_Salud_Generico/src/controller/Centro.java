package controller;

import model.Cita;
import model.Doctor;
import model.Paciente;

import java.util.ArrayList;
import java.util.Date;

public class Centro {
        private ArrayList<Paciente> listaPacientes;
        private ArrayList<Doctor> listaDoctores;
        private ArrayList<Cita> listaCitas;

    public Centro() {
        listaPacientes = new ArrayList<>();
        listaDoctores = new ArrayList<>();
        listaCitas = new ArrayList<>();
    }

    public Centro(ArrayList<Paciente> listaPacientes, ArrayList<Doctor> listaDoctores, ArrayList<Cita> listaCitas>) {
        this.listaPacientes = listaPacientes;
        this.listaDoctores = listaDoctores;
        this.listaCitas = listaCitas;
    }

    public void admitirPaciente(Paciente paciente){
        listaPacientes.add(paciente);
    }

    public void contratarDoctor(Doctor doctor){
        listaDoctores.add(doctor);
    }

    public void verPacientes(){
        for (Paciente paciente : listaPacientes){
            System.out.println(paciente.getNombre()+" "+paciente.getApellidos()+"Numero SS "+paciente.getNumSS());
        }
    }

    public void verCitasPaciente(Paciente paciente){
        for (Cita cita : listaCitas){
            System.out.println("Doctor asociado "+ cita.getDoctorAsociado());
            System.out.println("Fecha asociada "+ cita.getFechaCita());
            System.out.println("Paciente asociado "+cita.getPacienteAsociado());
            System.out.println("Especialidad asociada "+cita.getEspecialidad());
            System.out.println("-------------------------------------------------");
        }
    }

    public void verCitasDoctor(Doctor doctor){
        for (Cita cita : listaCitas){
            System.out.println("Doctor asociado "+ cita.getDoctorAsociado());
            System.out.println("Fecha asociada "+ cita.getFechaCita());
            System.out.println("Paciente asociado "+cita.getPacienteAsociado());
            System.out.println("Especialidad asociada "+cita.getEspecialidad());
            System.out.println("-------------------------------------------------");
        }
    }

    public void pedirCita(String numSS, String especialidad, Date fechaCita){
        Paciente paciente = null;
        
        for (Paciente paciente1 : listaCitas){
            if (paciente1.getNumSS()){
                paciente = paciente1;
                break;
            }else{
                System.out.println("Paciente no encontrado");
            }
        }
    }


    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }
}
