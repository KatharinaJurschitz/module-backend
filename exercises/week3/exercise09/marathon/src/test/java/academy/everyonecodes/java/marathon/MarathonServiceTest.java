package academy.everyonecodes.java.marathon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootTest
public class MarathonServiceTest {
    @Autowired
    MarathonService service;

    private final Runner steve = new Runner("Steve", Duration.of(55, ChronoUnit.HOURS));
    private final Runner lisa = new Runner("Steve", Duration.of(25, ChronoUnit.HOURS));
    private final Runner sam = new Runner("Steve", Duration.of(5, ChronoUnit.HOURS));

    @Test
    void add() {
        service.add(steve);
        service.add(lisa);
        service.add(sam);
        Set<Runner> runners = Set.of(steve, lisa, sam);
        Assertions.assertEquals(runners, service.getRunners());
    }

    @Test
    void findWinner() {
        var result = service.findWinner();
        var expected = Optional.of(sam);
        Assertions.assertEquals(expected, result);
    }
}
