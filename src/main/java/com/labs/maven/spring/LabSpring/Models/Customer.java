package com.labs.maven.spring.LabSpring.Models;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;
    private String surname;
    private int age;
    private String client_number;

    public Customer(String firstname, String surname, int age, String client_number)
    {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.client_number = client_number;
    }

    protected Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname (String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClient_number() {
        return client_number;
    }

    public void setClient_number(String client_number) {
        this.client_number = client_number;
    }

    @Override
    public boolean equals(Object obj)
    {
        Customer customer = (Customer) obj;
        return id == customer.id &&
                    firstname.equals(customer.firstname) &&
                    surname.equals(customer.surname) &&
                    age == customer.age &&
                    client_number.equals(customer.client_number);
    }
}
