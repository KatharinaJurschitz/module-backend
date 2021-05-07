package academy.everyonecodes.java.secretagenthandshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HandshakeNumberToMoveTranslatorTest {
    @Autowired
    HandshakeNumberToMoveTranslator translator;

    @ParameterizedTest
    @CsvSource({
            "2, thumb touches back",
            "3, little finger grab",
            "5, tickles over palm",
            "6, bro knock",
            "9, thousand knuckles",
            "0, ''",
            "1, ''",
            "4, ''",
            "7, ''",
            "8, ''",
    })
    void translate(int input, String expected) {
        var result = translator.translate(input);
        Assertions.assertEquals(expected, result);
    }
}
