package academy.everyonecodes.java.amazinghelloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorldTest {
    @Autowired
    World world;

    @Test
    void world_Test() {
        String result = world.get();
        String expected = "World";
        Assertions.assertEquals(expected, result);
    }
}
