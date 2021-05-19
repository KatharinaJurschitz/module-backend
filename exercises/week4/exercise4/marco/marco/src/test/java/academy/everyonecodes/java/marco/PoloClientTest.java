package academy.everyonecodes.java.marco;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PoloClientTest {
    @Autowired
    PoloClient client;

    @MockBean
    RestTemplate restTemplate;
    String url = "http://localhost:9001/polo";

    @Test
    void getPolo() {
        client.requestAnswer("Marco");
        Mockito.verify(restTemplate).postForObject(url, "Marco", String.class);
    }
}
