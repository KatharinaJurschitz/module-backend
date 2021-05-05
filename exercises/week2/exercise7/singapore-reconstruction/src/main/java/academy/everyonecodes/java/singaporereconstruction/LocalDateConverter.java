package academy.everyonecodes.java.singaporereconstruction;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@ConfigurationPropertiesBinding
public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String input) {
        return LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
