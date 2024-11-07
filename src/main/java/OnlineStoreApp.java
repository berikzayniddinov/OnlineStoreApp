import MVC.Controller.CartController;
import MVC.Model.Product;
import CreationalPatterns.Singleton.CartSingleton;
import StructuralPatterns.Decorator.ProductDiscountDecorator;
import MVC.view.CartView;
import BehavioralPatterns.Observer.PriceDropObserver;
public class OnlineStoreApp {
    public static void main(String[] args) {
        CartSingleton cartSingleton = new CartSingleton();
        CartController cartController = new CartController(cartSingleton.getInstance(), new CartView());

        Product laptop = new Product("Laptop", 1000.0);
        Product ebook = new Product("E-Book", 15.0);

        cartController.addProductToCart(laptop);
        cartController.addProductToCart(ebook);

        cartController.updateView();

        ProductDiscountDecorator discountedLaptop = new ProductDiscountDecorator(laptop, 10);
        System.out.println("Discount price: " + discountedLaptop.getDiscountedPrice());

        // Feature AliSina: Price Reduction Notification System
        // Subscribe to price drop notifications and product price changes
        PriceDropObserver priceObserver = new PriceDropObserver();
        priceObserver.subscribe(new User("Alice")); 
        laptop.setPriceObserver(priceObserver); 

        System.out.println("\n--- Price Drop Notification ---");
        System.out.println("Setting new price for laptop...");
        laptop.setPrice(900.0);

        
        cartController.updateView();
    }
}
