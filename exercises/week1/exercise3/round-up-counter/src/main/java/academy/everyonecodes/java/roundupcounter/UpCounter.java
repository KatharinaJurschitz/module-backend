package academy.everyonecodes.java.roundupcounter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpCounter {
    UpDownIndicator upDownIndicator;

    public UpCounter(UpDownIndicator upDownIndicator) {
        this.upDownIndicator = upDownIndicator;
    }

    public long count(List<Double> input) {
        return input.stream()
                .filter(x -> upDownIndicator.indicate(x).equals("UP"))
                .count();
    }
}
