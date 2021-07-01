package academy.everyonecodes.java;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
public class PoloEndpoint {
    private final PoloService service;

    public PoloEndpoint(PoloService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_USER")
    String post(@RequestBody String message) {
        return service.post(message);
    }
}
