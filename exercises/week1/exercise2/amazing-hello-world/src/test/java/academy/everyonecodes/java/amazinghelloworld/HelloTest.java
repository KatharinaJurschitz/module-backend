package academy.everyonecodes.java.amazinghelloworld;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTest {
    @Autowired
    Hello hello;

    @Test
    void hello_Test() {
        String result = hello.get();
        String expected = "Hello";
        Assertions.assertEquals(expected, result);
    }
}
