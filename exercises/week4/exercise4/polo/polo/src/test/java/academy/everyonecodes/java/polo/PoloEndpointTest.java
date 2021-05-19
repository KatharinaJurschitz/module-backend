package academy.everyonecodes.java.polo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PoloEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Polo polo;

    @Test
    void post() {
        String url = "/polo";
        restTemplate.postForObject(url, "Marco", String.class);
        Mockito.verify(polo).post("Marco");
    }
}
