package academy.everyonecodes.java.marco;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marco")
public class MarcoEndpoint {
    private final PoloClient client;

    public MarcoEndpoint(PoloClient client) {
        this.client = client;
    }

    @GetMapping("/{message}")
    String get(@PathVariable String message) {
        return client.requestAnswer(message);
    }
}
