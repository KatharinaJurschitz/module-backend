package academy.everyonecodes.java.calculator;

public abstract class Calculation {
    private final String symbol;

    public Calculation(String symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Expression expression) {
        return expression.getSymbol().equals(symbol);
    }

    public double calculate(Expression expression) {
        return switch (expression.getSymbol()) {
            case "+" -> expression.getTerm1() + expression.getTerm2();
            case "-" -> expression.getTerm1() - expression.getTerm2();
            case "*" -> expression.getTerm1() * expression.getTerm2();
            case "/" -> expression.getTerm1() / expression.getTerm2();
            default -> throw new IllegalArgumentException();
        };
    }
}
