package academy.everyonecodes.java.marcopolo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{text}")
public class MarcoPoloEndpoint {

    @GetMapping
    String getPolo(@PathVariable String text) {
        if (text.equalsIgnoreCase("Marco")) {
            return "Polo";
        } else {
            return "What?";
        }
    }
}
