package CreationalPatterns.Singleton;
import MVC.Model.Cart;

public class CartSingleton {
    private static Cart instance;

    public CartSingleton() {}

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }
}