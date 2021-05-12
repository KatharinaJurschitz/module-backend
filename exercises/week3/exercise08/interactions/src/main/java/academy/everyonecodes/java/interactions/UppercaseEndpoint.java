package academy.everyonecodes.java.interactions;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/uppercase")
public class UppercaseEndpoint {

    @PostMapping
    String post(@RequestBody String message) {
        return message.toUpperCase();
    }
}
