package com.example.webuy.models;

public class GroupPurchase {
    private int id, duration, quantity;
    private int promotionID;

    public GroupPurchase(int id, int duration, int quantity, int promotionID) {
        this.id = id;
        this.duration = duration;
        this.quantity = quantity;
        this.promotionID = promotionID;
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPromotionID() {
        return promotionID;
    }
}
