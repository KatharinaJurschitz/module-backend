package academy.everyonecodes.java.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultipleFinderTest {
    private MultipleFinder finderFive = new MultipleFinder(5);
    private MultipleFinder finderThree = new MultipleFinder(3);

    @ParameterizedTest
    @CsvSource({
            "8, false",
            "10, true",
            "0, true",
    })
    void isMultiple_Five(int input, boolean expected) {
        var result = finderFive.isMultiple(input);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({
            "8, false",
            "9, true",
            "0, true",
    })
    void isMultiple_Three(int input, boolean expected) {
        var result = finderThree.isMultiple(input);
        Assertions.assertEquals(expected, result);
    }
}
