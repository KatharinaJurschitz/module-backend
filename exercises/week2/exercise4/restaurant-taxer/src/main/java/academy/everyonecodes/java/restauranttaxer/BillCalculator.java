package academy.everyonecodes.java.restauranttaxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillCalculator {
    private final Set<Taxer> taxers;

    public BillCalculator(Set<Taxer> taxers) {
        this.taxers = taxers;
    }

    public double calculate(List<RestaurantDish> dishes) {
        double output = 0.0;
        for (RestaurantDish dish : dishes) {
            output += dish.getPrice() * findTax(dish);
        }
        return output;
    }

    private double findTax(RestaurantDish dish) {
        double output = 1.0;
        for (Taxer taxer : taxers) {
            if (taxer.matches(dish)) {
                output = taxer.getTax();
            }
        }
        return output;
    }
}