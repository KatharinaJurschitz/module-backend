package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    FilmService service;

    String url = "/films";

    @Test
    void getAll() {
        List<Film> list = List.of(new Film("test", 1));
        Mockito.when(service.getAll()).thenReturn(list);
        restTemplate.getForObject(url, Film[].class);
        Mockito.verify(service).getAll();

    }

    @Test
    void save() {
        Film test = new Film("test", 2);
        Mockito.when(service.save(test)).thenReturn(test);
        restTemplate.postForObject(url, test, Film.class);
        Mockito.verify(service).save(test);
    }
}
