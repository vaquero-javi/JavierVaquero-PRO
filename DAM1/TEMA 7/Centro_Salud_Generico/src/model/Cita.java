package model;

import java.util.Date;

public class Cita {
    private Date fechaCita;
    private String especialidad;
    private Doctor doctorAsociado;
    private Paciente pacienteAsociado;

    public Cita() {
    }

    public Cita(Date fechaCita, String especialidad, Doctor doctorAsociado, Paciente pacienteAsociado) {
        this.fechaCita = fechaCita;
        this.especialidad = especialidad;
        this.doctorAsociado = doctorAsociado;
        this.pacienteAsociado = pacienteAsociado;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Doctor getDoctorAsociado() {
        return doctorAsociado;
    }

    public void setDoctorAsociado(Doctor doctorAsociado) {
        this.doctorAsociado = doctorAsociado;
    }

    public Paciente getPacienteAsociado() {
        return pacienteAsociado;
    }

    public void setPacienteAsociado(Paciente pacienteAsociado) {
        this.pacienteAsociado = pacienteAsociado;
    }
}
