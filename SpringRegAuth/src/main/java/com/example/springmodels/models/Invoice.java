package com.example.springmodels.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "ФИО пациента не должно быть пустым")
    private String patientId;

    @NotNull(message = "Сумма оплаты не должна быть пустой")
    private double amount;

    @NotBlank(message = "Cтатус оплаты не должен быть пустым")
    private String isPaid;

    public Invoice() {
    }

    public Invoice(String patientId, double amount, String isPaid) {
        this.patientId = patientId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
}
