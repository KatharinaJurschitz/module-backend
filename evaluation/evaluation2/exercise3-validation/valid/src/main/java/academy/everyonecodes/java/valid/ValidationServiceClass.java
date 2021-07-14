package academy.everyonecodes.java.valid;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Service
public class ValidationServiceClass implements ValidationService{

    @Override
    public String showInput(@Size(min = 3) String input) {
        return input;
    }
}
