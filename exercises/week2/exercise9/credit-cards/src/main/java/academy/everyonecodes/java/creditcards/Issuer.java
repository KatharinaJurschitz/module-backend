package academy.everyonecodes.java.creditcards;

import java.util.Set;

public class Issuer {
    private String name;
    private Set<String> startsWith;
    private Set<Integer> lengths;

    public Issuer() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartsWith(Set<String> startsWith) {
        this.startsWith = startsWith;
    }

    public void setLength(Set<Integer> lengths) {
        this.lengths = lengths;
    }

    public String issues(String creditCardNumber) {
        if ((creditCardNumber.startsWith("34") || creditCardNumber.startsWith("37")) && creditCardNumber.length() == 15) {
            return "American Express";
        } else if ((creditCardNumber.startsWith("6011") || creditCardNumber.startsWith("645") || creditCardNumber.startsWith("646") || creditCardNumber.startsWith("644") ||
                creditCardNumber.startsWith("647") || creditCardNumber.startsWith("648") || creditCardNumber.startsWith("649") || creditCardNumber.startsWith("65")
                && (creditCardNumber.length() == 16 || creditCardNumber.length() == 19))) {
            return "Discover";
        } else if ((creditCardNumber.startsWith("51") || creditCardNumber.startsWith("52") || creditCardNumber.startsWith("53") ||
                creditCardNumber.startsWith("54") || creditCardNumber.startsWith("55")) && creditCardNumber.length() == 16) {
            return "MasterCard";
        } else if (creditCardNumber.startsWith("4") && (creditCardNumber.length() == 13 || creditCardNumber.length() == 16 || creditCardNumber.length() == 19)) {
            return "Visa";
        } else {
            return "not supported";
        }
    }
}
