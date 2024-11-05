package BehavioralPatterns.Strategy;
import MVC.Model.Product;

import java.util.List;

public interface RecommendationStrategy {
    List<Product> recommend(List<Product> products);
}
