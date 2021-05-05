package academy.everyonecodes.java.rockscissorspaper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameRunner {
    @Bean
    ApplicationRunner applicationRunner(Game game) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                game.play();
                System.exit(0);
            }
        };
    }


}
