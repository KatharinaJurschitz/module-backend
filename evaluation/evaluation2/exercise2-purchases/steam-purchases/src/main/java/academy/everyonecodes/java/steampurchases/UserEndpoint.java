package academy.everyonecodes.java.steampurchases;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<User> findAll() {
        return service.findAll();
    }
}
