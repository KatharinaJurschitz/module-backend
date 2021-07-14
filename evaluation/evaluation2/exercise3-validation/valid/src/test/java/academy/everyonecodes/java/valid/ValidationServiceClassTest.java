package academy.everyonecodes.java.valid;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class ValidationServiceClassTest {
    private final ValidationServiceClass service = new ValidationServiceClass();

    @Test
    public void noViolations() {
        String input = "test";
        var result = service.showInput(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    public void InputIsTooShort() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> service.showInput("te"));
    }

    @Test
    public void InputIsNull() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> service.showInput(null));
    }
}
