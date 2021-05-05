package academy.everyonecodes.java.restauranttaxer;

import java.util.List;

public abstract class Taxer {
    private final List<String> names;
    private final double tax;

    public Taxer(List<String> names, double tax) {
        this.names = names;
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public boolean matches(RestaurantDish input) {
        return names.contains(input.getName());
    }

    public double tax(RestaurantDish input) {
        double output = input.getPrice();
        if (matches(input)) {
            output *= tax;
        }
        return output;
    }
}
