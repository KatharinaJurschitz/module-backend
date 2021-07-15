package academy.everyonecodes.java.steampurchases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameEndpoint {
    private final GameService service;

    public GameEndpoint(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> findAll() {
        return service.findAll();
    }
}
