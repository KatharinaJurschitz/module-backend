package academy.everyonecodes.java.fleamarket;

import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/items")
public class FleaMarketEndpoint {
    private FleaMarketService service;

    public FleaMarketEndpoint(FleaMarketService service) {
        this.service = service;
    }

    @GetMapping
    Set<Item> getAll() {
        return service.getItems();
    }

    @PostMapping
    Item post(@RequestBody Item item) {
        service.add(item);
        return item;
    }

    @GetMapping("/{name}")
    Set<Item> getOne(@PathVariable String name) {
        return service.getOne(name);
    }
}
