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

        // Function Myrzan: Review and rating system
        // Add reviews to the product and display them on the screen
        System.out.println("\n--- Product Reviews ---");
        laptop.addReview(new Review(new User("Alice"), "Excellent laptop!", 5));
        ebook.addReview(new Review(new User("Bob"), "Good e-book, very useful.", 4));

        System.out.println("Reviews for " + laptop.getName() + ":");
        for (Review review : laptop.getReviews()) {
            System.out.println(review);
        }
        System.out.println("Reviews for " + ebook.getName() + ":");
        for (Review review : ebook.getReviews()) {
            System.out.println(review);
        }


        // Function Ibragim: Recommendations based on browsing history
        // Create browsing history and receive recommendations
        List<Product> viewedProducts = Arrays.asList(laptop);
        RecommendationStrategy recommendationStrategy = new RecommendationBasedOnHistory(viewedProducts);
        List<Product> recommendations = recommendationStrategy.recommend(Arrays.asList(laptop, ebook));

        System.out.println("\n--- Recommendations Based on Viewing History ---");
        for (Product recommendedProduct : recommendations) {
            System.out.println("- " + recommendedProduct.getName());
        }

        // Function AliSina: Price Reduction Notification System
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
