package academy.everyonecodes.java.basicproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChoiceTest {
    @Autowired
    Choice choice;

    @Test
    void get() {
        boolean result = choice.get();
        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }
}
