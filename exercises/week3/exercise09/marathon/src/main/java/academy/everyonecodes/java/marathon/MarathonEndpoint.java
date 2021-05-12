package academy.everyonecodes.java.marathon;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runners")
public class MarathonEndpoint {
    private MarathonService service;

    public MarathonEndpoint(MarathonService service) {
        this.service = service;
    }

    @PostMapping
    Runner add(@RequestBody Runner runner) {
        service.add(runner);
        return runner;
    }

    @GetMapping("/winner")
    Runner getWinner() {
        return service.findWinner().orElse(null);
    }
}
