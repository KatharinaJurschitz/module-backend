package academy.everyonecodes.java.steamusers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_APP")
    public User save(@RequestBody User user) {
        return service.save(user);
    }
}
