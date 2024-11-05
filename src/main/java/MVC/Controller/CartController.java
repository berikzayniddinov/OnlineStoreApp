package MVC.Controller;

import MVC.Model.Cart;
import MVC.Model.Product;
import MVC.view.CartView;

public class CartController {
    private Cart cart;
    private CartView view;

    public CartController(Cart cart, CartView view) {
        this.cart = cart;
        this.view = view;
    }

    public void addProductToCart(Product product) {
        cart.addItem(product);
        System.out.println("Product added to cart: " + product.getName());
    }

    public void removeProductFromCart(Product product) {
        cart.removeItem(product);
        System.out.println("Product removed from cart: " + product.getName());
    }

    public void updateView() {
        view.showCartContents(cart.getItems(), cart.getTotalPrice());
    }
}