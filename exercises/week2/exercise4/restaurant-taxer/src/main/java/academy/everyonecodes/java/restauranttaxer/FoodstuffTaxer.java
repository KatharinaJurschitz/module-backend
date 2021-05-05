package academy.everyonecodes.java.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodstuffTaxer extends Taxer {

    public FoodstuffTaxer(@Value("${restaurant.foodstuff.namesAsList}") List<String> names, @Value("${restaurant.foodstuff.tax}") double tax) {
        super(names, tax);
    }
}
