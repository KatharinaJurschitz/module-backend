package academy.everyonecodes.java.dorothy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DorothyEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Dorothy dorothy;

    @Test
    void requestAnswer() {
        String url = "/dorothy";
        restTemplate.getForObject(url, String.class);
        Mockito.verify(dorothy).interact();
    }
}
