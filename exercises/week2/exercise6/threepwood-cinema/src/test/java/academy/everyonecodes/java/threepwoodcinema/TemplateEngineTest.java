package academy.everyonecodes.java.threepwoodcinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TemplateEngineTest {
    @Autowired
    TemplateEngine engine;

    @ParameterizedTest
    @CsvSource({
            "Mr. Miller, Mr. Miller male",
            "Ms. Smith, Ms. Smith female",
            "Mrs. Smith, Mrs. Smith default",
            "Mary Threepwood, Mary Threepwood privileged",
            "Threepwood Mary, Threepwood Mary privileged",
            "John, John default",
    })
    void customize(String input, String expected) {
        var result = engine.customiseMessage(input);
        Assertions.assertEquals(expected, result);
    }
}
