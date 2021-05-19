package academy.everyonecodes.java.marathonintegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Configuration
public class RunnerConfiguration {
    @Bean
    Runner winner() {
        return new Runner("Sam", Duration.of(2, ChronoUnit.HOURS));
    }

    @Bean
    List<Runner> runners() {
        return List.of(
                new Runner("Sam", Duration.of(2, ChronoUnit.HOURS)),
                new Runner("Max", Duration.of(3, ChronoUnit.HOURS)),
                new Runner("Liv", Duration.of(4, ChronoUnit.HOURS)));
    }
}
