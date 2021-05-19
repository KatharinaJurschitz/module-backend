package academy.everyonecodes.java.jsonplaceholder;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {
    private final JsonPlaceholderClient client;

    public PostEndpoint(JsonPlaceholderClient client) {
        this.client = client;
    }

    @GetMapping
    List<Post> getAll() {
        return client.getAll();
    }

    @GetMapping("/{id}")
    Post getOne(@PathVariable int id) {
        return client.getOne(id);
    }

    @PostMapping
    Post post(@RequestBody Post post) {
        return client.post(post);
    }

    @PutMapping("/{id}")
    Post put(@RequestBody Post post, @PathVariable int id) {
        return client.modify(id, post);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        client.deleteOne(id);
    }
}
