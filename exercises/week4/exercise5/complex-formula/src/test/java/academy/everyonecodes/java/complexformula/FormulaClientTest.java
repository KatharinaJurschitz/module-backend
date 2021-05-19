package academy.everyonecodes.java.complexformula;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FormulaClientTest {
    @Autowired
    FormulaClient client;

    @MockBean
    RestTemplate restTemplate;
    String url = "http://localhost:8080/formula";

    @Test
    void requestAnswer() {
        client.requestAnswer(2);
        Mockito.verify(restTemplate).postForObject(url, 2, Integer.class);
    }
}
