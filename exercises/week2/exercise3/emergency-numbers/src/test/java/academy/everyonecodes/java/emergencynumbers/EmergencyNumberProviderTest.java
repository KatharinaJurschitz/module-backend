package academy.everyonecodes.java.emergencynumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmergencyNumberProviderTest {
    @Autowired
    EmergencyNumberProvider provider;

    @ParameterizedTest
    @CsvSource({
            "Fire brigade, 122",
            "fire brigade, 122",
            "Police, 133",
            "General, 112",
            "x, 112",
    })
    void provide(String input, int expected) {
        var result = provider.provide(input);
        Assertions.assertEquals(expected, result);
    }
}
