package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoManager {
    private final ToDoRepository repository;

    public ToDoManager(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDo saveNewToDo(String title) {
        ToDo todo = new ToDo(title);
        repository.save(todo);
        return todo;
    }

    public List<ToDo> findAllToDos() {
        return repository.findAll();
    }

    public Optional<ToDo> findOneToDo(String id) {
        return repository.findById(id);
    }

    public void markToDoAsDone(String id) {
        Optional<ToDo> todo = repository.findById(id);
        todo.ifPresent(toDo -> toDo.setDone(true));
        todo.ifPresent(repository::save);
    }

    public void deleteToDo(String id) {
        Optional<ToDo> todo = repository.findById(id);
        todo.ifPresent(repository::delete);
    }
}
