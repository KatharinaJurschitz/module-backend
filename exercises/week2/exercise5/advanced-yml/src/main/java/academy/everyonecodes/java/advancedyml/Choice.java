package academy.everyonecodes.java.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class Choice {
    private boolean choice;

    public Choice(boolean choice) {
        this.choice = choice;
    }

    public Choice() {}

    void setChoice(boolean choice) {
        this.choice = choice;
    }

    public boolean get() {
        return choice;
    }
}
