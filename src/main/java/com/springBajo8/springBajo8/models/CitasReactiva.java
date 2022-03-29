package com.springBajo8.springBajo8.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document(collection = "citas")
public class CitasReactiva {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String idPaciente;

    private String nombrePaciente;

    private String apellidosPaciente;

    private String nombreMedico;

    private String apellidosMedico;

    private LocalDate fechaReservaCita;

    private String horaReservaCita;

    private List<Padecimiento> tratamientosList;

    private String estadoReservaCita;

    //Constructor
    public CitasReactiva(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    //Constructor por defecto
    public CitasReactiva() {
    }

    //Getters y Setters---------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        this.apellidosMedico = apellidosMedico;
    }

    public LocalDate getFechaReservaCita() {
        return fechaReservaCita;
    }

    public void setFechaReservaCita(LocalDate fechaReservaCita) {
        this.fechaReservaCita = fechaReservaCita;
    }

    public String getHoraReservaCita() {
        return horaReservaCita;
    }

    public void setHoraReservaCita(String horaReservaCita) {
        this.horaReservaCita = horaReservaCita;
    }

    public String getEstadoReservaCita() {
        return estadoReservaCita;
    }

    public void setEstadoReservaCita(String estadoReservaCita) {
        this.estadoReservaCita = estadoReservaCita;
    }

    public List<Padecimiento> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Padecimiento> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }
    //Getters y Setters---------------------------------------------


    //toString


    @Override
    public String toString() {
        return "CitasReactiva{" +
                "id='" + id + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", apellidosPaciente='" + apellidosPaciente + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", apellidosMedico='" + apellidosMedico + '\'' +
                ", fechaReservaCita=" + fechaReservaCita +
                ", horaReservaCita='" + horaReservaCita + '\'' +
                ", tratamientosList=" + tratamientosList +
                ", estadoReservaCita='" + estadoReservaCita + '\'' +
                '}';
    }
}
