package academy.everyonecodes.java.threepwoodcinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TemplateMessageFinderTest {
    @Autowired
    TemplateMessageFinder finder;

    @ParameterizedTest
    @CsvSource({
            "Mr. Miller, --name-- male",
            "Ms. Smith, --name-- female",
            "Mrs. Smith, --name-- default",
            "Mary Threepwood, --name-- privileged",
            "Threepwood Mary, --name-- privileged",
            "John, --name-- default",
    })
    void find(String input, String expected) {
        var result = finder.find(input);
        Assertions.assertEquals(expected, result);
    }
}
