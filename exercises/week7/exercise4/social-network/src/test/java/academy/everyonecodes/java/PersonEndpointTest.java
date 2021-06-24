package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    PersonService service;

    String url = "/persons";

    @Test
    void save() {
        PersonDTO dto = new PersonDTO("name");
        restTemplate.postForObject(url, dto, PersonDTO.class);
        Mockito.verify(service).save(dto);
    }

    @Test
    void findAll() {
        restTemplate.getForObject(url, PersonDTO[].class);
        Mockito.verify(service).findAll();
    }

    @Test
    void friend() {
        String nUrl = url + "/1/friend/2";
        restTemplate.put(nUrl, 1L, 2L, Void.class);
        Mockito.verify(service).friend(1L, 2L);
    }

    @Test
    void unfriend() {
        String nUrl = url + "/1/unfriend/2";
        restTemplate.put(nUrl, 1L, 2L, Void.class);
        Mockito.verify(service).unfriend(1L, 2L);
    }
}
