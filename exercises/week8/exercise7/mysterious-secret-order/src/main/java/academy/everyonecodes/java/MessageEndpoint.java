package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageEndpoint {
    private final String message;

    public MessageEndpoint(@Value("${message}") String message) {
        this.message = message;
    }

    @GetMapping
    @Secured({"ROLE_MASTER", "ROLE_APPRENTICE"})
    public String getMessage() {
        return message;
    }
}
