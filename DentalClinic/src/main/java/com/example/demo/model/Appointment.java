package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appointment {
    // запись на прием
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;
    private String patientId;
    private String dentistId;

    public Appointment(int id, Date appointmentDate, String patientId, String dentistId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.patientId = patientId;
        this.dentistId = dentistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDentistId() {
        return dentistId;
    }

    public void setDentistId(String dentistId) {
        this.dentistId = dentistId;
    }
}
