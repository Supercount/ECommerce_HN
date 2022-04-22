package com.example.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="Products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private final static double TAUX_TVA = 0.2;
    @Column(length = 24, nullable = false)
    private String name;
    @Column(length = 500, nullable = false)
    private String description;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private EnumColor color;
    @ManyToOne
    private Category category;


    private String picture;

    public Product() {
    }
    public Product(String name, String description, double price, EnumColor color, Category category, String picture) {    
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.category = category;
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", color=" + color +
                ", category=" + category +
                '}';
    }
}
