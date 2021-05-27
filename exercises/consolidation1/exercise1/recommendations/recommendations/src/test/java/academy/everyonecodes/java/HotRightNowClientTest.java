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
public class HotRightNowClientTest {
    @Autowired
    HotRightNowClient client;

    @MockBean
    RestTemplate restTemplate;

    @Value("${url.hot}")
    String url;

    @Test
    void getRecomms() {
        Movie[] expected = {new Movie("test1", "test1")};

        Mockito.when(restTemplate.getForObject(url, Movie[].class)).thenReturn(expected);
        var result = client.getHots();
        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(url, Movie[].class);
    }

}
