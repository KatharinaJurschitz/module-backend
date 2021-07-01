package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

@Service
public class PoloService {
    public String post(String message) {
        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
