package academy.everyonecodes.java.roundupcounter;

import org.springframework.stereotype.Service;

@Service
public class Rounder {
    public double roundUp(double input) {
        return Math.ceil(input);
    }

    public double roundDown(double input) {
        return Math.floor(input);
    }
}
