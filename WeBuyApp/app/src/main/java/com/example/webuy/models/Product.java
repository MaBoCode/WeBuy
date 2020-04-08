package com.example.webuy.models;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String label, description, image;

    public Product(int id, String label, String description, String image) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
