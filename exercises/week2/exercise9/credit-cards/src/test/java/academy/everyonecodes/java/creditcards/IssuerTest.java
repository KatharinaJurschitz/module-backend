package academy.everyonecodes.java.creditcards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IssuerTest {
    private Issuer issuer = new Issuer();

    @ParameterizedTest
    @CsvSource({
            "371449635398431, American Express",
            "6011111111111117, Discover",
            "5105105105105100, MasterCard",
            "4222222222222241, Visa",
            "6011000990139424, Discover",
            "3566002020360505, not supported",
    })
    void issues(String input, String expected) {
        var result = issuer.issues(input);
        Assertions.assertEquals(expected, result);
    }
}
