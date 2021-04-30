package academy.everyonecodes.java.calculator;

import org.springframework.stereotype.Service;

@Service
public class ExpressionParser {
    public Expression parse(String input) {
        String[] parts = input.split(" ");
        double term1 = Double.parseDouble(parts[0]);
        String symbol = parts[1];
        double term2 = Double.parseDouble(parts[2]);
        return new Expression(symbol, term1, term2);
    }
}
