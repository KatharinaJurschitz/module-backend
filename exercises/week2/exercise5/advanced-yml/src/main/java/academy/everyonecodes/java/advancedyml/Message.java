package academy.everyonecodes.java.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {}

    void setMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
