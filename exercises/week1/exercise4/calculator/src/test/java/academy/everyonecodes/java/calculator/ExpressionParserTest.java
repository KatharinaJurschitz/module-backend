package academy.everyonecodes.java.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

@SpringBootTest
public class ExpressionParserTest {
    @Autowired
    ExpressionParser parser;

    @ParameterizedTest
    @MethodSource("inputData")
    void parse_Test(String input, Expression expected) {
        var result = parser.parse(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        "2 - 6", new Expression("-", 2.0, 6.0)
                ),
                Arguments.of(
                        "9.7 * 6", new Expression("*", 9.7, 6.0)
                ),
                Arguments.of(
                        "2.1 / 0", new Expression("/", 2.1, 0.0)
                ),
                Arguments.of(
                        "1 3 6", new Expression("3", 1.0, 6.0)
                )
        );
    }
}
