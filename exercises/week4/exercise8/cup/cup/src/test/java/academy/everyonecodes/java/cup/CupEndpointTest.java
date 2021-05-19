package academy.everyonecodes.java.cup;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CupEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Cup cup;

    @Test
    void requestIfCoin() {
        String url = "/cup";
        restTemplate.getForObject(url, Boolean.class);
        Mockito.verify(cup).checkForCoin();
    }

    @Test
    void putCoin() {
        String url = "/cup";
        restTemplate.put(url, Boolean.class);
        Mockito.verify(cup).addCoin();
    }

    @Test
    void removeCoin() {
        String url = "/cup";
        restTemplate.delete(url);
        Mockito.verify(cup).removeCoin();
    }
}
