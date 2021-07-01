package academy.everyonecodes.java;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class UserEndpoint {
    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_MASTER")
    User postUser(@RequestBody User user) {
        return service.postUser(user);
    }

    @GetMapping("/apprentice")
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    List<User> getApprentices() {
        return service.getApprentices();
    }

    @GetMapping
    @Secured("ROLE_MASTER")
    List<User> getUsers() {
        return service.getUsers();
    }
}
