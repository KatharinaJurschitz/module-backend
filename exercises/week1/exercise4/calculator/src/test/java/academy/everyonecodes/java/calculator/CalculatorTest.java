package academy.everyonecodes.java.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

@SpringBootTest
class CalculatorTest {
    @Autowired
    Calculator calculator;

    @ParameterizedTest
    @MethodSource("inputData")
    void calculate_Test(String input, double expected) {
        var result = calculator.calculate(input);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        "8.8 + 1.3", 10.1
                ),
                Arguments.of(
                        "8.8 - 1.3", 7.5
                ),
                Arguments.of(
                        "8.8 * 1.3", 11.44
                ),
                Arguments.of(
                        "8.8 / 1.3", 6.769230769230769230769230769
                )
        );
    }

    @Test
    void calculate_Exception() {
        String input = "8.8 x 1.3";
        Assertions.assertThrows(IllegalArgumentException.class,() -> calculator.calculate(input));
    }
}
