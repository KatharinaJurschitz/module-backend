package academy.everyonecodes.java.basicproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DecimalNumberTest {
    @Autowired
    DecimalNumber decimalNumber;

    @Test
    void get() {
        double result = decimalNumber.get();
        double expected = 1.618;
        Assertions.assertEquals(expected, result, 0.00001);
    }
}
