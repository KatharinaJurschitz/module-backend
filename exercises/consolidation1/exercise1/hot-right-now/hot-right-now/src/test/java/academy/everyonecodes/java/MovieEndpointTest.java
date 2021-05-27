package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MovieStore movieStore;

    @Test
    void getHot() {
        String url = "/movies";
        Mockito.when(movieStore.getAllHotRightNow()).thenReturn(List.of(new Movie("1", "2")));
        var result = restTemplate.getForObject(url, Movie[].class);
        var expected = new Movie[1];
        expected[0] = new Movie("1", "2");
        Assertions.assertEquals(expected[0], result[0]);
        Mockito.verify(movieStore).getAllHotRightNow();
    }
}
