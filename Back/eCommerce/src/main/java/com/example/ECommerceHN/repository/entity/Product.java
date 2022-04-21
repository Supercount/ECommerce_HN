package com.example.ECommerceHN.repository.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final static double TAUX_TVA = 0.2;
    @Column(length = 24, nullable = false)
    private String name;
    @Column(length = 248, nullable = false)
    private String description;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private EnumGender gender;
    @ManyToOne
    private Type type;

    public Product() {
    }
    public Product(String name, String description, double price, EnumGender gender, Type type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.gender = gender;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
