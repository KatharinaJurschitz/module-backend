package academy.everyonecodes.java.advancedyml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaturalNumberTest {
    @Autowired
    NaturalNumber naturalNumber;

    @Test
    void get() {
        int result = naturalNumber.get();
        int expected = 369;
        Assertions.assertEquals(expected, result);
    }
}
