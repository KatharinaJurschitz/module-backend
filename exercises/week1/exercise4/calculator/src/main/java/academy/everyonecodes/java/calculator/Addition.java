package academy.everyonecodes.java.calculator;

import org.springframework.stereotype.Service;

@Service
public class Addition extends Calculation {
    public Addition() {
        super("+");
    }
}
