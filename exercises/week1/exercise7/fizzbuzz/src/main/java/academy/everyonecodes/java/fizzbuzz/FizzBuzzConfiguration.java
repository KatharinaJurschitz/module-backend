package academy.everyonecodes.java.fizzbuzz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FizzBuzzConfiguration {
    @Bean
    FizzBuzz fizzBuzz() {
        return new FizzBuzz(new MultipleFinder(3), new MultipleFinder(5));
    }

}
