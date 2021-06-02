package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemSelectionEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Basket basket;

    @Test
    void postItem() {
        String url = "/itemselections";
        ItemSelection item = new ItemSelection("test", "test", 1.0);
        restTemplate.postForObject(url, item, Void.class);
        Mockito.verify(basket).addSummary(item);
    }
}
