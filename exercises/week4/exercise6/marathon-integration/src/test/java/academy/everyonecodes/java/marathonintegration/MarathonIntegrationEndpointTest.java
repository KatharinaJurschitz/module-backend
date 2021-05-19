package academy.everyonecodes.java.marathonintegration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarathonIntegrationEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MarathonTester tester;

    @Test
    void get() {
        String url = "/marathon/integration";
        restTemplate.getForObject(url, TestResult.class);
        Mockito.verify(tester).test();
    }
}
