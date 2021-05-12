package academy.everyonecodes.java.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/academies")
@ConfigurationProperties("education")
public class AcademyEndpoint {
    private List<Academy> academies;

    public AcademyEndpoint(List<Academy> academies) {
        this.academies = academies;
    }

    public AcademyEndpoint() {}

    public void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }

    @GetMapping
    List<Academy> getAcademies() {
        return academies;
    }
}
