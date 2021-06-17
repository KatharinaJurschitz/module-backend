package academy.everyonecodes.java;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PunchCardRunner {

    @Bean
    ApplicationRunner runPunchCard(PunchCardService service) {
        return args -> {
            service.punch();
        };
    }
}
