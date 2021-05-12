package academy.everyonecodes.java.marathon;

import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MarathonService {
    private final Set<Runner> runners = new HashSet<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    public Optional<Runner> findWinner() {
        Optional<Duration> smallest = runners.stream().map(Runner::getDuration).findFirst();
        return runners.stream()
                .filter(x -> x.getDuration().compareTo(smallest.get()) < 0)
                .findFirst();
    }

    Set<Runner> getRunners() {
        return runners;
    }
}
