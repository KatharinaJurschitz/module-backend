package academy.everyonecodes.java.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzTest {
    @Autowired
    FizzBuzz fizzBuzz;

    @ParameterizedTest
    @CsvSource({
            "0, FizzBuzz",
            "6, Fizz",
            "10, Buzz",
            "15, FizzBuzz",
            "17, 17",
    })
    void apply(int input, String expected) {
        var result = fizzBuzz.apply(input);
        Assertions.assertEquals(expected, result);
    }
}
