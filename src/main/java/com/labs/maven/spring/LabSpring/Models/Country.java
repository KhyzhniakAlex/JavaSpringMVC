package com.labs.maven.spring.LabSpring.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String region;
    private String population;

    public Country(String name, String region, String population)
    {
        this.name = name;
        this.region = region;
        this.population = population;
    }

    protected Country(){

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }


    @Override
    public boolean equals(Object obj)
    {
        Country country = (Country)obj;
        return id == country.id &&
                name.equals(country.name) &&
                region.equals(country.region) &&
                population.equals(country.population);
    }
}
