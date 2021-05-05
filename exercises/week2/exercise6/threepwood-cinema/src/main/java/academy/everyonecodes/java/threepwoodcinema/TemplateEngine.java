package academy.everyonecodes.java.threepwoodcinema;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {
    private TemplateMessageFinder finder;

    public TemplateEngine(TemplateMessageFinder finder) {
        this.finder = finder;
    }

    void setFinder(TemplateMessageFinder finder) {
        this.finder = finder;
    }

    public String customiseMessage(String name) {
        return finder.find(name).replaceAll("--name--", name);
    }
}
