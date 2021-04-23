import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenderRatioCalculatorTest {
    private GenderRatioCalculator calculator = new GenderRatioCalculator();

    @Test
    void calculate() {
        String result = calculator.calculate();
        String expected = "518:482";
        Assertions.assertEquals(expected, result);
    }
}
