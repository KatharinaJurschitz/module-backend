package academy.everyonecodes.java.amazinggoodbyeworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorldTest {
    @Autowired
    World world;

    @Test
    void get_World() {
        String result = world.get();
        String expected = "World";
        Assertions.assertEquals(expected, result);
    }
}
