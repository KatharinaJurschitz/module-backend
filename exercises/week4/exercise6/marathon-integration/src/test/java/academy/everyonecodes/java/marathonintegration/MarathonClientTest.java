package academy.everyonecodes.java.marathonintegration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MarathonClientTest {
    @Autowired
    MarathonClient client;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void getWinner() {
        String url = "/runners/winner";
        client.getWinner();
        Mockito.verify(restTemplate).getForObject(url, Runner.class);
    }

    @Test
    void postRunner() {
        String url = "/runners";
        Runner input = new Runner("Sam", Duration.of(2, ChronoUnit.HOURS));
        client.postRunner(input);
        Mockito.verify(restTemplate).postForObject(url, input, Runner.class);
    }
}
