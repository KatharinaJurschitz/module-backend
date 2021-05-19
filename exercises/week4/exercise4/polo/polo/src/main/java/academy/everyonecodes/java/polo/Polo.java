package academy.everyonecodes.java.polo;

import org.springframework.stereotype.Service;

@Service
public class Polo {
    public String post(String message) {
        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
