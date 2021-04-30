package academy.everyonecodes.java.fizzbuzz;

import org.springframework.beans.factory.annotation.Value;

public class MultipleFinder {
    private final int multiple;

    public MultipleFinder(int multiple) {
        this.multiple = multiple;
    }

    public boolean isMultiple(int input) {
        return input % multiple == 0;
    }
}
