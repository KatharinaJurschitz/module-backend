package academy.everyonecodes.java.valid;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Validated
public interface ValidationService {

    String showInput(@Size(min = 3) String input);
}
