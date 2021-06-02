package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
    private final UserStore store;

    public UserEndpoint(UserStore store) {
        this.store = store;
    }

    @GetMapping("/{email}")
    User getUser(@PathVariable String email) {
        var user = store.getUser(email);
        return user.orElseGet(() -> new User(null, null, null));
    }
}
