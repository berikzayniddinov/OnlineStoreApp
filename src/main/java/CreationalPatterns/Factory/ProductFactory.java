package CreationalPatterns.Factory;
import MVC.Model.Product;

public class ProductFactory {
    public static Product createProduct(String name, double price) {
        return new Product(name, price);
    }
}