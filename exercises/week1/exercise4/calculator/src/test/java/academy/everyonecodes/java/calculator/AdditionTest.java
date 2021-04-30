package academy.everyonecodes.java.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

@SpringBootTest
class AdditionTest {
    @Autowired
    Addition addition;

    @ParameterizedTest
    @MethodSource("inputData")
    void calculate_add(Expression input, double expected) {
        var result = addition.calculate(input);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        new Expression("+", 8.8, 1.3), 10.1
                ),
                Arguments.of(
                        new Expression("+", 0.0, 0.0), 0.0
                ),
                Arguments.of(
                        new Expression("+", 8.8, 0.0), 8.8
                ),
                Arguments.of(
                        new Expression("+", 0.0, 1.3), 1.3
                )
        );
    }
}
