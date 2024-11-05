package BehavioralPatterns.Strategy;
import MVC.Model.Product;
import java.util.List;


class PopularRecommendation implements RecommendationStrategy {
    @Override
    public List<Product> recommend(List<Product> products) {
        return products;
    }
}