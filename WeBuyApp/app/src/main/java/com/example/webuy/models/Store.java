package com.example.webuy.models;

public class Store {
    private int id;
    private String name, address, logo;
    private double latitude, longitude;

    public Store(int id, String name, String address, String logo, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.logo = logo;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLogo() {
        return logo;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
