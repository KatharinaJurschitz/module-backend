package academy.everyonecodes.java.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeEndpoint {

    @GetMapping
    String getLocation() {
        return "Kansas";
    }
}
