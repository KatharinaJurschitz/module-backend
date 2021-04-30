package academy.everyonecodes.java.amazinggoodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodbyeTest {
    @Autowired
    Goodbye goodbye;

    @Test
    void get_Goodbye() {
        String result = goodbye.get();
        String expected = "Goodbye";
        Assertions.assertEquals(expected, result);
    }
}
