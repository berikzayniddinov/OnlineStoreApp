package StructuralPatterns.Decorator;
import MVC.Model.Product;

public class ProductDiscountDecorator {
    private Product product;
    private double discount;

    public ProductDiscountDecorator(Product product, double discount) {
        this.product = product;
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        return product.getPrice() * (1 - discount / 100);
    }
}