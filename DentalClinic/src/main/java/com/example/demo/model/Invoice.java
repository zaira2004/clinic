package com.example.demo.model;

public class Invoice {
    // счёт
    private int id;
    private String patientId;
    private double amount;
    private boolean isPaid;

    public Invoice(int id, String patientId, int amount, boolean isPaid) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
        this.isPaid = false;
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

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
