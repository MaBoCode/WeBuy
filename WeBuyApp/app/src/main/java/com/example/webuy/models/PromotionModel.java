package com.example.webuy.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class PromotionModel {

    private ArrayList<Promotion> dataModel;

    public PromotionModel(int size) {
        dataModel = new ArrayList<>();
        generate(size);
    }

    public void generate(int size) {
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        for(int i = 0; i < size; i++) {
            String title = "Product title " + String.valueOf(i);
            String description = "Product description " + String.valueOf(i);
            float oldPrice = Float.parseFloat(decimalFormat.format(30 + random.nextFloat() * (100 - 30)));
            float newPrice = Float.parseFloat(decimalFormat.format(oldPrice / 6));

            Promotion promotion = new Promotion(title, description, oldPrice, newPrice);
            dataModel.add(promotion);
        }
    }

    public ArrayList<Promotion> getDataModel() {
        return dataModel;
    }

    public static class Promotion {
        private String productTitle;
        private String productDescription;
        private float oldPrice;
        private float newPrice;

        public Promotion(String productTitle, String productDescription, float oldPrice, float newPrice) {
            this.productTitle = productTitle;
            this.productDescription = productDescription;
            this.oldPrice = oldPrice;
            this.newPrice = newPrice;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public float getOldPrice() {
            return oldPrice;
        }

        public void setOldPrice(float oldPrice) {
            this.oldPrice = oldPrice;
        }

        public float getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(float newPrice) {
            this.newPrice = newPrice;
        }
    }
}
