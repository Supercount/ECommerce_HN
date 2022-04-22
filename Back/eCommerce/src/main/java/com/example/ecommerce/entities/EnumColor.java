package com.example.ecommerce.entities;

public enum EnumColor {
    YELLOW("jaune"), PINK("rose"), WHITE("blanc");

    private final String color;

    EnumColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
