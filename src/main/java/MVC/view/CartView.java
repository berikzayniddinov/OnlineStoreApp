package MVC.view;

import MVC.Model.Product;
import java.util.List;

public class CartView {
    public void showCartContents(List<Product> items, double totalPrice) {
        System.out.println("Items in your cart:");
        for (Product item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total cost: $" + totalPrice);
    }
}
