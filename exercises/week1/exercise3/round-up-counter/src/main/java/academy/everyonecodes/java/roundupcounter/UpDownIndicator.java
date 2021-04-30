package academy.everyonecodes.java.roundupcounter;

import org.springframework.stereotype.Service;

@Service
public class UpDownIndicator {
    private final Rounder rounder;

    public UpDownIndicator(Rounder rounder) {
        this.rounder = rounder;
    }

    public String indicate(double input) {
        double diffUp = rounder.roundUp(input) - input;
        double diffDown = input - rounder.roundDown(input);

        if (diffUp < 0.5 && diffUp > 0) {
            return "UP";
        } else if (diffDown < 0.5 && diffDown > 0) {
            return "DOWN";
        } else {
            return "SAME";
        }
    }
}
