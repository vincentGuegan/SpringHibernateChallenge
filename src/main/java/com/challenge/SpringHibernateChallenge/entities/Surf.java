package com.challenge.SpringHibernateChallenge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surf {

    public Surf() {
    }

    public Surf(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;

    private String brand;

    private int price;

    @Override
    public String toString() { 
        return "Surf [id=" + id + ", name=" + name + 
                ", brand=" + brand + ", price=" + price + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }    

}