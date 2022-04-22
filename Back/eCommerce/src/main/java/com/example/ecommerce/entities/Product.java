package com.example.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name="Products")
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
    private ColorEnum color;
    @ManyToOne
    private Category category;
    private String image;

    public Product() {
    }
    public Product(String name, String description, double price, ColorEnum color, Category category, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.color = color;
        this.category = category;
        this.image= image;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    
}
