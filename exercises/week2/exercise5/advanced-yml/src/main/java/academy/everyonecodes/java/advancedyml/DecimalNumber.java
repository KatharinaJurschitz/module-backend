package academy.everyonecodes.java.advancedyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class DecimalNumber {
    private double decimalnumber;

    public DecimalNumber(double decimalnumber) {
        this.decimalnumber = decimalnumber;
    }

    public DecimalNumber() {}

    void setDecimalNumber(double decimalnumber) {
        this.decimalnumber = decimalnumber;
    }

    public double get() {
        return decimalnumber;
    }
}
