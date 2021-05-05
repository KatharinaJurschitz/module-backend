package academy.everyonecodes.java.restauranttaxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class BillCalculatorTest {
    @Autowired
    BillCalculator calculator;

    @ParameterizedTest
    @MethodSource("inputData")
    void tax(List<RestaurantDish> input, double expected) {
        var result = calculator.calculate(input);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    static Stream<Arguments> inputData() {
        List<RestaurantDish> dishes1 = List.of(
                new RestaurantDish("soda", 1.80),       //2.16
                new RestaurantDish("milk", 1.80),       //1.80
                new RestaurantDish("tiramisu", 6.10));  //6.71
        List<RestaurantDish> dishes2 = List.of(new RestaurantDish("", 0.0));

        return Stream.of(
                Arguments.of(dishes1, 10.67),
                Arguments.of(dishes2, 0.0)
        );
    }
}
