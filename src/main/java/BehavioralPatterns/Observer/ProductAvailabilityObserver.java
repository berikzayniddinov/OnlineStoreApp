package BehavioralPatterns.Observer;
import MVC.Model.Product;
import java.util.List;
import java.util.ArrayList;
import MVC.Model.User;

public class ProductAvailabilityObserver {
    private List<User> subscribers = new ArrayList<>();

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void notifySubscribers(Product product) {
        for (User user : subscribers) {
            user.notify("Товар " + product.getName() + " теперь доступен!");
        }
    }
}
