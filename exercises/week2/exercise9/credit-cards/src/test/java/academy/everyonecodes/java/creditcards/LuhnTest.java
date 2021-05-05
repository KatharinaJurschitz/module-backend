package academy.everyonecodes.java.creditcards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuhnTest {
    @Autowired
    Luhn luhn;

    @ParameterizedTest
    @CsvSource({
            "371449635398431, true",
            "5105105105105100, true",
            "22210000000000, false",
    })
    void isValid(String input, boolean expected) {
        var result = luhn.isValid(input);
        Assertions.assertEquals(expected, result);
    }
}
