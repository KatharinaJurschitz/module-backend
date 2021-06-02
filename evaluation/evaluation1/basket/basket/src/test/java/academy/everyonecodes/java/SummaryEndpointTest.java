package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SummaryEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    @Test
    void get() {
        String url = "/summaries";
        restTemplate.getForObject(url, Summary[].class);
        Mockito.verify(basket).getSummaries();
    }
}
