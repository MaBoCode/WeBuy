package com.example.webuy.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Promotion implements Serializable {
    private int id;
    private String oldPrice, newPrice;
    private int minQuantity;
    private transient Product product;
    private transient Store store;

    public Promotion(int id, String oldPrice, String newPrice, int minQuantity, Product product, Store store) {
        this.id = id;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.minQuantity = minQuantity;
        this.product = product;
        this.store = store;
    }

    public Promotion(int id, String oldPrice, String newPrice, int minQuantity, Product product) {
        this.id = id;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.minQuantity = minQuantity;
        this.product = product;
        this.store = null;
    }

    protected Promotion(Parcel in) {
        id = in.readInt();
        oldPrice = in.readString();
        newPrice = in.readString();
        minQuantity = in.readInt();
    }

    /*
    public static final Creator<Promotion> CREATOR = new Creator<Promotion>() {
        @Override
        public Promotion createFromParcel(Parcel in) {
            return new Promotion(in);
        }

        @Override
        public Promotion[] newArray(int size) {
            return new Promotion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(oldPrice);
        dest.writeString(newPrice);
        dest.writeInt(minQuantity);
        dest.writeSerializable(product);
    }
     */

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

    public Product getProduct() {
        return product;
    }

    public Store getStore() {
        return store;
    }
}
