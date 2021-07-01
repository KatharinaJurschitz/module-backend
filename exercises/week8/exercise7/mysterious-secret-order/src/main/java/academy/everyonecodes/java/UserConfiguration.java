package academy.everyonecodes.java;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("master")
public class UserConfiguration {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Bean
    ApplicationRunner adminUser(UserRepository repository, PasswordEncoder encoder) {
        return args -> {
            if (repository.existsByUsername(user.getUsername())) {
                return;
            }
            String password = user.getPassword();
            String encoded = encoder.encode(password);
            user.setPassword(encoded);
            repository.save(user);
        };
    }
}
