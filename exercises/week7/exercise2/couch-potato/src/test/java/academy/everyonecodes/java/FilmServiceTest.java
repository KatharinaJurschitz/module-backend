package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FilmServiceTest {
    @Autowired
    FilmService service;

    @MockBean
    FilmRepository repository;

    @Test
    void getAll() {
        List<Film> list = List.of(new Film("test", 1));
        Mockito.when(repository.findAll()).thenReturn(list);
        var result = service.getAll();
        Assertions.assertEquals(list, result);
        Mockito.verify(repository).findAll();

    }

    @Test
    void save() {
        Film test = new Film("test", 2);
        Mockito.when(repository.save(test)).thenReturn(test);
        var result = service.save(test);
        Assertions.assertEquals(test, result);
        Mockito.verify(repository).save(test);
    }
}
