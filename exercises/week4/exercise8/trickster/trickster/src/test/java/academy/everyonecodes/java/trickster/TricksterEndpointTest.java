package academy.everyonecodes.java.trickster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TricksterEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Trickster trickster;

    @Test
    void play() {
        String url = "/play";
        restTemplate.getForObject(url, String.class);
    }

    @Test
    void hasCoin() {
        String url = "/choose/0";
        restTemplate.getForObject(url, Boolean.class);
    }
}
