package com.example.demo.model;

public class Dentist {
    private int id;
    private String name;
    private String specialization;
    private String licenseNumber;
    private String clinicName;

    public Dentist(int id, String name, String specialization, String licenseNumber, String clinicName) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.clinicName = clinicName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
