package academy.everyonecodes.java.advancedtypes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@ConfigurationProperties("education")
public class AcademyConfiguration {
    private List<Academy> academies;

    public AcademyConfiguration(List<Academy> academies) {
        this.academies = academies;
    }

    public AcademyConfiguration() {}

    public void setAcademies(List<Academy> academies) {
        this.academies = academies;
    }
}
