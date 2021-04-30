package academy.everyonecodes.java.amazinghelloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmazingHelloWorldTest {
    @Autowired
    AmazingHelloWorld amazingHelloWorld;

    @Test
    void amazingHelloWorld_Test() {
        String result = amazingHelloWorld.get();
        String expected = "Hello World";
        Assertions.assertEquals(expected, result);
    }
}
