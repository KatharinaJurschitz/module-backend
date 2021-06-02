package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UsersClientTest {
    @Autowired
    UsersClient client;

    @MockBean
    RestTemplate restTemplate;

    String url = "http://localhost:9001/users/test";

    @Test
    void getUser() {
        User test = new User("test", "test");
        Mockito.when(restTemplate.getForObject(url, User.class)).thenReturn(test);
        client.getUser("test");
        Mockito.verify(restTemplate).getForObject(url, User.class);
    }
}
