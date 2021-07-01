package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NeverTooLateEndpoint {

    @GetMapping
    public String get() {
        return "It's never too late.";
    }
}
