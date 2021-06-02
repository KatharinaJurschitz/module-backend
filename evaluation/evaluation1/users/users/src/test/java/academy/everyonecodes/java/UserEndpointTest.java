package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    UserStore store;

    @Test
    void getUser() {
        String url = "/users/test-mail";
        restTemplate.getForObject(url, User.class);
        Mockito.verify(store).getUser("test-mail");
    }
}
