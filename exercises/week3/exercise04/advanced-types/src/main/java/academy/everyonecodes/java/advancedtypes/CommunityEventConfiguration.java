package academy.everyonecodes.java.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class CommunityEventConfiguration {
    private List<CommunityEvent> events;

    public CommunityEventConfiguration() {
    }

    public void setEvents(List<CommunityEvent> events) {
        this.events = events;
    }

    public CommunityEventConfiguration(List<CommunityEvent> events) {
        this.events = events;
    }
}
