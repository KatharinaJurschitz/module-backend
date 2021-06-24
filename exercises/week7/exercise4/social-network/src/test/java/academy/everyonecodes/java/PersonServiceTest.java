package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PersonServiceTest {
    @Autowired
    PersonService service;

    @MockBean
    PersonRepository repository;

    private final Person p1 = new Person(1L, "name1", List.of());
    private final Person p2 = new Person(2L, "name1", List.of());


    @Test
    void save() {
        PersonDTO dto = new PersonDTO("name");
        service.save(dto);
        Mockito.verify(repository).save(new Person("name"));
    }

    @Test
    void findAll() {
        service.findAll();
        Mockito.verify(repository).findAll();
    }

    @Test
    void friend() {
        service.friend(1L, 2L);
        Mockito.verify(repository).findById(1L);
        Mockito.verify(repository).findById(2L);
        Mockito.verify(repository).save(p1);
        Mockito.verify(repository).save(p2);
        Assertions.assertEquals(1, p1.getFriends().size());
        Assertions.assertEquals(1, p2.getFriends().size());
    }

    @Test
    void unfriend() {
        service.unfriend(1L, 2L);
        Mockito.verify(repository).findById(1L);
        Mockito.verify(repository).findById(2L);
        Mockito.verify(repository).save(p1);
        Mockito.verify(repository).save(p2);
        Assertions.assertEquals(0, p1.getFriends().size());
        Assertions.assertEquals(0, p2.getFriends().size());
    }
}
