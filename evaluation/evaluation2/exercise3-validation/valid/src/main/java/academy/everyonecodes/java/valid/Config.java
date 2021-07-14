package academy.everyonecodes.java.valid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class Config {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ValidationServiceClass showInputService() {
        return new ValidationServiceClass();
    }
}
