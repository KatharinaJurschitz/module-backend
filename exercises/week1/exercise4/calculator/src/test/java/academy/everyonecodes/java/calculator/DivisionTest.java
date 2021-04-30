package academy.everyonecodes.java.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

@SpringBootTest
class DivisionTest {
    @Autowired
    Division division;

    @ParameterizedTest
    @MethodSource("inputData")
    void calculate_divide(Expression input, double expected) {
        var result = division.calculate(input);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        new Expression("/", 8.8, 1.3), 6.769230769230769230769230769
                ),
                Arguments.of(
                        new Expression("/", 0.0, 0.0), Double.NaN
                ),
                Arguments.of(
                        new Expression("/", 8.8, 0.0), Double.POSITIVE_INFINITY
                ),
                Arguments.of(
                        new Expression("/", 0.0, 1.3), 0.0
                )
        );
    }
}
