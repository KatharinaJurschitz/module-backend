package academy.everyonecodes.java.roundupcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpDownTest {
    @Autowired
    UpDownIndicator upDownIndicator;

    @ParameterizedTest
    @CsvSource({
            "2.58, UP",
            "10.13, DOWN",
            "99.99, UP",
            "1.01, DOWN",
            "1.5, SAME"
    })
    void updown_Test(double input, String expected) {
        var result = upDownIndicator.indicate(input);
        Assertions.assertEquals(expected, result);
    }
}
