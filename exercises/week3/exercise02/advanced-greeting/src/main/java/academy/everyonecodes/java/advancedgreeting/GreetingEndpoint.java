package academy.everyonecodes.java.advancedgreeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@ConfigurationProperties("")
public class GreetingEndpoint {
    private String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    String getMessage() {
        return greeting;
    }
}
