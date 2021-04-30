package academy.everyonecodes.java.amazinggoodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AmazingGoodbyeWorldTest {
    @Autowired
    AmazingGoodbyeWorld amazingGoodbyeWorld;

    @Test
    void get_Amazing() {
        String result = amazingGoodbyeWorld.get();
        String expected = "Goodbye World";
        Assertions.assertEquals(expected, result);
    }
}
