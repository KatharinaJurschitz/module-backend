package academy.everyonecodes.java.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysteriousNumberFormatterTest {
    @Autowired
    MysteriousNumberFormatter formatter;

    @ParameterizedTest
    @CsvSource({
            "0, The mysterious number is 0",
            "5, The mysterious number is 5",
    })
    void format(int input, String expected) {
        var result = formatter.format(input);
        Assertions.assertEquals(expected, result);
    }
}
