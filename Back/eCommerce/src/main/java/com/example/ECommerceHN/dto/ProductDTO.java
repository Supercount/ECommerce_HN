package com.example.ECommerceHN.dto;

public class ProductDTO {

    private long id;
    private String name;
    private String description;
    private double price;
    private String color;
    private String category;
    private String picture;

    public ProductDTO(String name, String description, double price, String color, String category, String picture) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
