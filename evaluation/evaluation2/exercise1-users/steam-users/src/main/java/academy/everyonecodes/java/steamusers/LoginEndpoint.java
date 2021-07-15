package academy.everyonecodes.java.steamusers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginEndpoint {
    private final LoginService service;

    public LoginEndpoint(LoginService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_USER")
    public String login() {
        return service.login();
    }
}
