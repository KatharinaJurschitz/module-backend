package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CountdownManager {
    private final CountdownRepository countdownRepository;
    private final AccumulationManager accumulationManager;
    private final int countdownStart;

    public CountdownManager(CountdownRepository countdownRepository, AccumulationManager accumulationManager, @Value("${countdown.start}") int countdownStart) {
        this.countdownRepository = countdownRepository;
        this.accumulationManager = accumulationManager;
        this.countdownStart = countdownStart;
    }

    public void countdown() {
        if (doesntExistCountdown()) {
            createCountdown();
        } else {
            reduceCountdown();
        }
    }

    private boolean doesntExistCountdown() {
        return countdownRepository.count() == 0;
    }

    private void createCountdown() {
        Countdown countdown = new Countdown(countdownStart);
        countdownRepository.save(countdown);
        System.out.println("Countdown: " + countdown.getCount());
    }

    public void reduceCountdown() {
        Countdown countdown = countdownRepository.findAll().get(0);
        int count = countdown.getCount();
        countdown.setCount(count - 1);
        if (countdown.getCount() > 0) {
            countdownRepository.save(countdown);
            System.out.println("Countdown: " + countdown.getCount());
        } else {
            countdownRepository.delete(countdown);
            accumulationManager.accumulate();
        }
    }
}
