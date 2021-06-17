package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ToDoManagerTest {
    @Autowired
    ToDoManager manager;

    @MockBean
    ToDoRepository repository;

    @Test
    void saveNew() {
        manager.saveNewToDo("test");
        Mockito.verify(repository).save(new ToDo("test"));
    }

    @Test
    void findAll() {
        manager.findAllToDos();
        Mockito.verify(repository).findAll();
    }

    @Test
    void findOne() {
        Optional<ToDo> oToDo = Optional.of(new ToDo("test"));
        Mockito.when(repository.findById("test")).thenReturn(oToDo);
        manager.findOneToDo("test");
        Mockito.verify(repository).findById("test");
    }

    @Test
    void markDone() {
        Optional<ToDo> oToDo = Optional.of(new ToDo("test"));
        Mockito.when(repository.findById("test")).thenReturn(oToDo);
        manager.markToDoAsDone("test");
        Mockito.verify(repository).save((oToDo.get()));
        Mockito.verify(repository).findById("test");
    }

    @Test
    void delete() {
        Optional<ToDo> oToDo = Optional.of(new ToDo("test"));
        Mockito.when(repository.findById("test")).thenReturn(oToDo);
        manager.deleteToDo("test");
        Mockito.verify(repository).findById("test");
        Mockito.verify(repository).delete(oToDo.get());
    }
}
