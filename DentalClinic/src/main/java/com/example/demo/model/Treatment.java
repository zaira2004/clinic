package com.example.demo.model;

public class Treatment {
    //Лечение
    private int id;
    private String name;
    private String description;
    private double cost;

    public Treatment(int id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
