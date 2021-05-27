package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TailoredRecommendationsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TailoredRecommendationsStore store;

    @Test
    void get() {
        String url = "/tailoredrecommendations/123abc";
        var result = restTemplate.getForObject(url, Movie[].class);
        Mockito.verify(store).getRecommendations("123abc");
    }

    @Test
    void post() {
        String url = "/tailoredrecommendations";
        TailoredRecommendation test = new TailoredRecommendation("123abc", new Movie("test2", "test2"));
        var result = restTemplate.postForObject(url, test, TailoredRecommendation.class);
        Mockito.verify(store).postNewRecommendation(test);
    }
}
