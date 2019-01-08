package com.labs.maven.spring.LabSpring.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
    private int prise;
    private String color;

    /*@JsonCreator
    public Car(@JsonProperty(value = "brand", required = true) String brand,
               @JsonProperty(value = "model", required = true) String model,
               @JsonProperty(value = "prise", required = true) int prise,
               @JsonProperty(value = "color", required = true) String color)
    {
        this.brand = brand;
        this.model = model;
        this.prise = prise;
        this.color = color;
    }*/

    public Car(String brand, String model, int prise, String color)
    {
        this.brand = brand;
        this.model = model;
        this.prise = prise;
        this.color = color;
    }

    protected Car(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj)
    {
        Car car = (Car)obj;
        return id == car.id &&
                    brand.equals(car.brand) &&
                    model.equals(car.model) &&
                    prise == car.prise &&
                    color.equals(car.color);
    }
}

