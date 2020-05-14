package models;

public class Promotion {
    private final long id;
    private Product product;
    private double discountPrice;

    public Promotion(long id, Product product, double discountPrice) {
        this.id = id;
        this.product = product;
        this.discountPrice = discountPrice;
    }

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }
}
