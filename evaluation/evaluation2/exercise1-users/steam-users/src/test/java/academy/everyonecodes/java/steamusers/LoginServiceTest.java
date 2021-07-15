package academy.everyonecodes.java.steamusers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LoginServiceTest {
    @Autowired
    LoginService service;

    @Value("${login.message}")
    String message;

    @Test
    void login() {
        var result = service.login();
        Assertions.assertEquals("test", result);
    }
}
