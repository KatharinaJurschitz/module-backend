package academy.everyonecodes.java.mysteriouscalculator;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MysteriousNumberCalculator {
    private final Set<MysteriousAddition> mysteriousAdditionSet;
    private final MysteriousNumberFormatter formatter;

    public MysteriousNumberCalculator(Set<MysteriousAddition> mysteriousAdditionSet, MysteriousNumberFormatter formatter) {
        this.mysteriousAdditionSet = mysteriousAdditionSet;
        this.formatter = formatter;
    }

    public String calculate(int number) {
        int result = 0;
        for (MysteriousAddition mysteriousAddition : mysteriousAdditionSet) {
            result += mysteriousAddition.apply(number);
        }
        return formatter.format(result);
    }
}
