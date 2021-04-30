package academy.everyonecodes.java.mysteriouscalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MysteriousAdditionTest {
    private final MysteriousAddition mysteriousAdditionOne = new MysteriousAddition(1);
    private final MysteriousAddition mysteriousAdditionTwo = new MysteriousAddition(2);

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "0, 1",
            "9, 10",
    })
    void applyOne(int input, int expected) {
        var result = mysteriousAdditionOne.apply(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3",
            "0, 2",
            "9, 11",
    })
    void applyTwo(int input, int expected) {
        var result = mysteriousAdditionTwo.apply(input);
        Assertions.assertEquals(expected, result);
    }
}
