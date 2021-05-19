package academy.everyonecodes.java.polo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PoloTest {
    @Autowired
    Polo polo;

    @ParameterizedTest
    @CsvSource({
            "Marco, Polo",
            "marco, What?",
            "'', What?",
    })
    void post(String input, String expected) {
        var result = polo.post(input);
        Assertions.assertEquals(expected, result);
    }
}
