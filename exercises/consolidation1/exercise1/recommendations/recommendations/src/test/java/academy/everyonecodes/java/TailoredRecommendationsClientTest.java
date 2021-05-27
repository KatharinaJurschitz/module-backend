package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TailoredRecommendationsClientTest {
    @Autowired
    TailoredRecommendationsClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${url.tailored}")
    String url;

    @Test
    void getRecomms() {
        String userUrl = url + "/123abc";
        Movie[] expected = {new Movie("test1", "test1")};

        Mockito.when(restTemplate.getForObject(userUrl, Movie[].class)).thenReturn(expected);
        var result = client.getRecomms("123abc");
        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(userUrl, Movie[].class);
    }
}
