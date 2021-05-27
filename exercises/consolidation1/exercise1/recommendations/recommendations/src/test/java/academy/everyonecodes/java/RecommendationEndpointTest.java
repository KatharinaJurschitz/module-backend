package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecommendationEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    RecommendationService service;

    @Test
    void get() {
        String url = "/recommendations/123abc";
        var result = restTemplate.getForObject(url, Movie[].class);
        Mockito.verify(service).get("123abc");
    }
}
