package academy.everyonecodes.java.steamusers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String message;

    public LoginService(@Value("${login.message}") String message) {
        this.message = message;
    }

    public String login() {
        return message;
    }
}
