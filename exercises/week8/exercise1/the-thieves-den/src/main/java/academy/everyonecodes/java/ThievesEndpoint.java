package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasures")
public class ThievesEndpoint {

    @GetMapping
    public String get() {
        return " One Thousand and One Nights";
    }
}
