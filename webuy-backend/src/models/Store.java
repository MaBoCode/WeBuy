package models;

import java.util.List;

public class Store {
    private long id = -1;
    private String name;
    private List<Promotion> promotions;

    public Store(String name, List<Promotion> promotions) {
        this.name = name;
        this.promotions = promotions;
    }

    public Store(long id, String name, List<Promotion> promotions) {
        this.id = id;
        this.name = name;
        this.promotions = promotions;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
