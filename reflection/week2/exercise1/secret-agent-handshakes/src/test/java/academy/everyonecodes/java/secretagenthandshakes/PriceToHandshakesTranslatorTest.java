package academy.everyonecodes.java.secretagenthandshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class PriceToHandshakesTranslatorTest {
    @Autowired
    PriceToHandshakesTranslator translator;

    @ParameterizedTest
    @MethodSource("inputData")
    void translate(int input, List<String> expected) {
        var result = translator.translate(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(10, List.of()),
                Arguments.of(10000, List.of()),
                Arguments.of(147, List.of()),
                Arguments.of(69, List.of("bro", "thousand")),
                Arguments.of(3020, List.of("little", "thumb")),
                Arguments.of(5000, List.of("tickles"))
        );
    }
}
