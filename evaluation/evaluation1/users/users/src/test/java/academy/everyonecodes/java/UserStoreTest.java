package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class UserStoreTest {
    @Autowired
    UserStore store;

    @Test
    void getUserFound() {
        var result = store.getUser("test-mail");
        var expected = Optional.of(new User("Test", "test-mail", "test account"));
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getUserNotFound() {
        var result = store.getUser("bla");
        var expected = Optional.empty();
        Assertions.assertEquals(expected, result);
    }
}
