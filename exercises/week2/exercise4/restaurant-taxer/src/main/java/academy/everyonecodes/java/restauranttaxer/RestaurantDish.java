package academy.everyonecodes.java.restauranttaxer;

public class RestaurantDish {
    private final String name;
    private final double price;

    public RestaurantDish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
