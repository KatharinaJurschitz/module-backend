package academy.everyonecodes.java.drhousediagnoses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@ConfigurationProperties("diagnosis")
public class DiagnosisConfiguration {
    private final List<Diagnosis> diagnoses;

    public DiagnosisConfiguration(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Bean
    List<Diagnosis> diagnoses() {
        return diagnoses;
    }
}
