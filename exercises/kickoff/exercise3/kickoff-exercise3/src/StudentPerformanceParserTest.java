import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class StudentPerformanceParserTest {
    private StudentPerformanceParser parser = new StudentPerformanceParser();

    @ParameterizedTest
    @MethodSource("inputData")
    void parseLine(String input, StudentPerformance expected) {
        StudentPerformance result = parser.parseLine(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        "male;high school;64;64;67",
                        new StudentPerformance("male", "high school",
                                64, 64, 67)
                )
        );
    }
}
