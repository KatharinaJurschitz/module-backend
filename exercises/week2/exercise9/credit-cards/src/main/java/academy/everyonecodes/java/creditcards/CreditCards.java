package academy.everyonecodes.java.creditcards;

import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class CreditCards {
    private Set<Issuer> issuers;
    private Luhn luhn;

    public CreditCards(Set<Issuer> issuers, Luhn luhn) {
        this.issuers = issuers;
        this.luhn = luhn;
    }

    public String inspect(String creditCardNumber) {
        if (luhn.isValid(creditCardNumber)) {
            for (Issuer issuer : issuers) {
                return issuer.issues(creditCardNumber);
            }
        }
        return "invalid";
    }
}
