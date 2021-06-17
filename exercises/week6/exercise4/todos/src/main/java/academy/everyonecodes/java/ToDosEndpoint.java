package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class ToDosEndpoint {
    private final ToDoManager manager;

    public ToDosEndpoint(ToDoManager manager) {
        this.manager = manager;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return manager.findAllToDos();
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getOneToDo(@PathVariable String id) {
        return manager.findOneToDo(id);
    }

    @PostMapping
    public ToDo saveToDo(@RequestBody String title) {
        return manager.saveNewToDo(title);
    }

    @PutMapping("/{id}/done")
    public Optional<ToDo> markToDoAsDone(@PathVariable String id) {
        var oTodo = manager.findOneToDo(id);
        if (oTodo.isPresent()) {
            manager.markToDoAsDone(id);
        }
        return manager.findOneToDo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable String id) {
        var oTodo = manager.findOneToDo(id);
        if (oTodo.isPresent()) {
            manager.deleteToDo(id);
        }
    }
}
