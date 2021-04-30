package academy.everyonecodes.java.goodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodbyeWorldTest {
    @Autowired
    GoodbyeWorld goodbyeWorld;

    @Test
    void get_GoodbyeWorld() {
        String result = goodbyeWorld.get();
        String expected = "Goodbye World";
        Assertions.assertEquals(expected, result);
    }
}
