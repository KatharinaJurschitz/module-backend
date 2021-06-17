package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDosEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ToDoManager manager;

    String url = "/todos";

    @Test
    void getAll() {
        restTemplate.getForObject(url, ToDo[].class);
        Mockito.verify(manager).findAllToDos();
    }

    @Test
    void getOne() {
        String nUrl = url + "/test";
        restTemplate.getForObject(nUrl, ToDo.class);
        Mockito.verify(manager).findOneToDo("test");
    }

    @Test
    void save() {
        restTemplate.postForObject(url, "title", ToDo.class);
        Mockito.verify(manager).saveNewToDo("title");
    }

    @Test
    void markDone() {
        String nUrl = url + "/test/done";
        Mockito.when(manager.findOneToDo("test")).thenReturn(Optional.of(new ToDo("title")));
        restTemplate.put(nUrl, new ToDo("title"), ToDo.class);
        Mockito.verify(manager).markToDoAsDone("test");
        Mockito.verify(manager, Mockito.times(2)).findOneToDo("test");
    }

    @Test
    void delete() {
        String nUrl = url + "/test";
        Mockito.when(manager.findOneToDo("test")).thenReturn(Optional.of(new ToDo("title")));
        restTemplate.delete(nUrl, Void.class);
        Mockito.verify(manager).findOneToDo("test");
        Mockito.verify(manager).deleteToDo("test");
    }
}
