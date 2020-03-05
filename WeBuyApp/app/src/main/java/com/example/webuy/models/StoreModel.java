package com.example.webuy.models;

import java.util.ArrayList;

public class StoreModel {
    private ArrayList<Store> dataModel;

    public StoreModel(int size) {
        dataModel = new ArrayList<>();

        generate(size);
    }

    public void generate(int size) {
        for(int i = 0; i < size; i++) {
            String name = "Store name " + String.valueOf(i);

            Store store = new Store(name);

            dataModel.add(store);
        }
    }

    public ArrayList<Store> getDataModel() {
        return dataModel;
    }

    public static class Store {
        private String name;

        public Store(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
