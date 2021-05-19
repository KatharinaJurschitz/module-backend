package academy.everyonecodes.java.marathonintegration;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MarathonTester {
    private final MarathonClient client;
    private final Runner winner;
    private final List<Runner> runners;

    public MarathonTester(MarathonClient client, Runner winner, List<Runner> runners) {
        this.client = client;
        this.winner = winner;
        this.runners = runners;
    }

    public TestResult test() {
        Optional<Runner> oRunner = Optional.ofNullable(client.getWinner());
        if (oRunner.isPresent()) {
            return new TestResult("error", "No winner should have been received in the first call");
        }
        runners.forEach(client::postRunner);
        Runner runner = client.getWinner();
        if (winner.equals(runner)) {
           return new TestResult("success", "Tests run correctly");
        }
        return new TestResult("error", "Incorrect winner received");
    }
}
