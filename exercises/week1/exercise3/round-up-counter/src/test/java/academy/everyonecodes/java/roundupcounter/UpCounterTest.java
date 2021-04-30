package academy.everyonecodes.java.roundupcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class UpCounterTest {
    @Autowired
    UpCounter upCounter;

    @ParameterizedTest
    @MethodSource("inputData")
    void upcounter_Test(List<Double> input, long expected) {
        var result = upCounter.count(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        List.of(2.58, 10.13, 99.99, 1.01, 1.00), 2
                ),
                Arguments.of(
                        List.of(2.58), 1
                ),
                Arguments.of(
                        List.of(2.28, 10.13, 99.19, 1.01, 1.00), 0
                ),
                Arguments.of(
                        List.of(1.50), 0
                ),
                Arguments.of(
                        List.of(), 0
                )
        );
    }
}
