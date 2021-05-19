package academy.everyonecodes.java.trickster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CupsClientTest {
    @Autowired
    CupsClient cupsClient;

    @MockBean
    RestTemplate restTemplate;
    @Value("${cups}") List<String> cups = new ArrayList<>();

    @Test
    void checkForCoin() {
        cupsClient.checkForCoin(0);
        Mockito.verify(restTemplate).getForObject(cups.get(0), Boolean.class);
    }

    @Test
    void addCoin() {
        cupsClient.addCoin(0);
        Mockito.verify(restTemplate).put(cups.get(0), Boolean.class);
    }

    @Test
    void removeCoin() {
        cupsClient.removeCoin(0);
        Mockito.verify(restTemplate).delete(cups.get(0));
    }

    @Test
    void numberOfCups() {
        var result = cupsClient.numberOfCups();
        var expected = 3;
        Assertions.assertEquals(expected, result);
    }

}
