package academy.everyonecodes.java.complexformula;

import org.springframework.stereotype.Service;
import java.util.stream.Stream;

@Service
public class ComplexFormula {
    private final FormulaClient client;

    public ComplexFormula(FormulaClient client) {
        this.client = client;
    }

    public int calculate(int input) {
        String[] digitsString = String.valueOf(input).split("");
        String output = Stream.of(digitsString)
                .map(Integer::parseInt)
                .map(client::requestAnswer)
                .map(String::valueOf)
                .reduce("", String::concat);
        return Integer.parseInt(output);
    }
}
