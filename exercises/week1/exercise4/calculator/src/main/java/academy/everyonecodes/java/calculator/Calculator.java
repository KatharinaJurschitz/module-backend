package academy.everyonecodes.java.calculator;

import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class Calculator {
    private final ExpressionParser parser;
    private final Set<Calculation> calculations;


    public Calculator(ExpressionParser parser, Set<Calculation> calculations) {
        this.parser = parser;
        this.calculations = calculations;
    }

    public double calculate(String input) {
        Expression expression = parser.parse(input);

        for (Calculation calculation : calculations) {
            if (calculation.matches(expression)) {
                return calculation.calculate(expression);
            }
        }
        throw new IllegalArgumentException();
    }
}
