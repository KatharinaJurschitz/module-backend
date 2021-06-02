package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Basket {
    private final SummaryCalculator calculator;
    private final List<Summary> summaries = new ArrayList<>();

    public Basket(SummaryCalculator calculator) {
        this.calculator = calculator;
    }

    public void addSummary(ItemSelection itemSelection) {
        summaries.add(calculator.getSummary(itemSelection));
    }

    public List<Summary> getSummaries() {
        return summaries;
    }
}
