package academy.everyonecodes.java.wizard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WizardEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void requestUrlFromHome() {
        String url = "/wizard";
        var result = restTemplate.getForObject(url, String.class);
        var expected = "http://localhost:9002/home";
        Assertions.assertEquals(expected, result);
    }
}
