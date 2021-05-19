package academy.everyonecodes.java.cup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CupTest {
    @Autowired
    Cup cup;

    @Test
    void addCoin() {
        cup.addCoin();
        var result = cup.checkForCoin();
        Assertions.assertTrue(result);
    }

    @Test
    void removeCoin() {
        cup.removeCoin();
        var result = cup.checkForCoin();
        Assertions.assertFalse(result);
    }
}
