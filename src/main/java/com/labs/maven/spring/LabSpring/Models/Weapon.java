package com.labs.maven.spring.LabSpring.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="weapons")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String brand;
    private int rate_of_fire;
    private String caliber;

    @JsonCreator
    public Weapon(@JsonProperty(value = "name", required = true) String name,
                  @JsonProperty(value = "brand", required = true) String brand,
                  @JsonProperty(value = "rate_of_fire", required = true) int rate_of_fire,
                  @JsonProperty(value = "caliber", required = true) String caliber)
    {
        this.name = name;
        this.brand = brand;
        this.rate_of_fire = rate_of_fire;
        this.caliber = caliber;
    }

    protected Weapon(){

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

    public void setName (String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRate() {
        return rate_of_fire;
    }

    public void setRate(int rate_of_fire) {
        this.rate_of_fire = rate_of_fire;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    @Override
    public boolean equals(Object obj)
    {
        Weapon weapon = (Weapon) obj;
        return id == weapon.id &&
                    name.equals(weapon.name) &&
                    brand.equals(weapon.brand) &&
                    rate_of_fire == weapon.rate_of_fire &&
                    caliber.equals(weapon.caliber);
    }
}
