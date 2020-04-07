package com.example.webuy.models;

public class Promotion {
    private int id;
    private String oldPrice, newPrice;
    private int minQuantity;
    private int productID, storeID;

    public Promotion(int id, String oldPrice, String newPrice, int minQuantity, int productID, int storeID) {
        this.id = id;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.minQuantity = minQuantity;
        this.productID = productID;
        this.storeID = storeID;
    }

    public int getId() {
        return id;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public int getStoreID() {
        return storeID;
    }
}
