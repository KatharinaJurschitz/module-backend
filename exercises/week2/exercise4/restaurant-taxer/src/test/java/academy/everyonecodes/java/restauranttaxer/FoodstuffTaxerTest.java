package academy.everyonecodes.java.restauranttaxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

@SpringBootTest
public class FoodstuffTaxerTest {
    @Autowired
    FoodstuffTaxer taxer;

    @ParameterizedTest
    @MethodSource("inputData")
    void tax(RestaurantDish input, double expected) {
        var result = taxer.tax(input);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new RestaurantDish("potato soup", 6.10), 6.71),
                Arguments.of(new RestaurantDish("tiramisu", 6.10), 6.71),
                Arguments.of(new RestaurantDish("", 0.0), 0.0),
                Arguments.of(new RestaurantDish("steak", 6.10), 6.10)
        );
    }
}
