package com.example.ecommerce.entities;

public enum EnumColor {
    GOLD("gold"), PINK("rose"), SILVER("silver");

    private final String color;

    EnumColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
