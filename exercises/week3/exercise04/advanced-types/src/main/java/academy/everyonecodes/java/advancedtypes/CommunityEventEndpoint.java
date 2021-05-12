package academy.everyonecodes.java.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/events")
@ConfigurationProperties("education")
public class CommunityEventEndpoint {
    List<CommunityEvent> events;

    public CommunityEventEndpoint(List<CommunityEvent> events) {
        this.events = events;
    }

    public CommunityEventEndpoint() {}

    public void setEvents(List<CommunityEvent> events) {
        this.events = events;
    }

    @GetMapping
    List<CommunityEvent> getEvents() {
        return events;
    }
}
