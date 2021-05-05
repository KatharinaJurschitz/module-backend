package academy.everyonecodes.java.creditcards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreditCardsTest {
    @Autowired
    CreditCards creditCards;

    @ParameterizedTest
    @CsvSource({
            "371449635398431, American Express",
            "6011111111111117, Discover",
            "5105105105105100, MasterCard",
            "4222222222222, Visa",
            "6011000990139424, Discover",
            "3566002020360505, not supported",
            "22210000000000, invalid",
    })
    void issues(String input, String expected) {
        var result = creditCards.inspect(input);
        Assertions.assertEquals(expected, result);
    }
}
