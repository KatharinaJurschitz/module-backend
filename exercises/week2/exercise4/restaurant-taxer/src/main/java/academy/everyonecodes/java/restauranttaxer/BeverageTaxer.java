package academy.everyonecodes.java.restauranttaxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BeverageTaxer extends Taxer {
    public BeverageTaxer(@Value("${restaurant.beverages.namesAsList}") List<String> names, @Value("${restaurant.beverages.tax}") double tax) {
        super(names, tax);
    }
}
