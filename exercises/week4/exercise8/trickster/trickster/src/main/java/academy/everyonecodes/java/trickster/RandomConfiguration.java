package academy.everyonecodes.java.trickster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Random;

@Configuration
public class RandomConfiguration {
    @Bean
    Random random() {
        return new Random();
    }
}
