package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LanguageEndpoint {
    private final String messageAll;
    private final String messageChoose;
    private final String messageGerman;
    private final String messageEnglish;
    private int count;

    public LanguageEndpoint(@Value("${language-school.messages.all}") String messageAll,
                            @Value("${language-school.messages.language}") String messageChoose,
                            @Value("${language-school.messages.german}") String messageGerman,
                            @Value("${language-school.messages.english}") String messageEnglish) {
        this.messageAll = messageAll;
        this.messageChoose = messageChoose;
        this.messageGerman = messageGerman;
        this.messageEnglish = messageEnglish;
        this.count = 0;
    }

    @GetMapping("/")
    public String getAll() {
        return messageAll;
    }

    @GetMapping("/languages")
    @Secured("ROLE_USER")
    public String getChoose() {
        count++;
        return messageChoose;
    }

    @GetMapping("/languages/german")
    @Secured("ROLE_LANGUAGE_GERMAN")
    public String getGerman() {
        count++;
        return messageGerman;
    }

    @GetMapping("/languages/english")
    @Secured("ROLE_LANGUAGE_ENGLISH")
    public String getEnglish() {
        count++;
        return messageEnglish;
    }

    @GetMapping("/interactions")
    @Secured("ROLE_ADMIN")
    public int count() {
        return count;
    }
}
