package com.gapgemini.jpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Customer {
    @Id
    private int id;
    private String name;
    private String city;

    public Customer() {}

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // getters and setters
}
