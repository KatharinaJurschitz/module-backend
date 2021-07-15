package academy.everyonecodes.java.steampurchases;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    GameService service;

    String url= "/games";

    @Test
    void findAll() {
        var result = restTemplate.getForObject(url, Game[].class);
        Mockito.verify(service).findAll();
    }
}
