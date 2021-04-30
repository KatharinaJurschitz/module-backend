package academy.everyonecodes.java.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysteriousNumberCalculatorTest {
    @Autowired
    MysteriousNumberCalculator calculator;

    @ParameterizedTest
    @CsvSource({
            "0, The mysterious number is 3",
            "5, The mysterious number is 13",
            "7, The mysterious number is 17",
    })
    void calculate(int input, String expected) {
        var result = calculator.calculate(input);
        Assertions.assertEquals(expected, result);
    }
}
