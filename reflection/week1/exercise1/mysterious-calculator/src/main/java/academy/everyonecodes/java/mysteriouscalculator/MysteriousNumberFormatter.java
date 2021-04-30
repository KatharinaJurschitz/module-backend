package academy.everyonecodes.java.mysteriouscalculator;

import org.springframework.stereotype.Service;

@Service
public class MysteriousNumberFormatter {
    public String format(int number) {
        return "The mysterious number is " + number;
    }
}
