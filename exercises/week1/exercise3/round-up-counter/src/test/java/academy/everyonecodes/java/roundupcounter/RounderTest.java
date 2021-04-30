package academy.everyonecodes.java.roundupcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RounderTest {
    @Autowired
    Rounder rounder;

    @ParameterizedTest
    @CsvSource({
            "2.58, 2.00",
            "10.13, 10.00",
            "99.99, 99.00",
            "1.01, 1.00",
    })
    void rounder_roundDown(double input, double expected) {
        var result = rounder.roundDown(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "2.58, 3.00",
            "10.13, 11.00",
            "99.99, 100.00",
            "1.01, 2.00",
    })
    void rounder_roundUp(double input, double expected) {
        var result = rounder.roundUp(input);
        Assertions.assertEquals(expected, result);
    }
}
