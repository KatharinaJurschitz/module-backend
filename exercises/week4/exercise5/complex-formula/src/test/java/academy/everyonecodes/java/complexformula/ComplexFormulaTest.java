package academy.everyonecodes.java.complexformula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ComplexFormulaTest {
    @Autowired
    ComplexFormula complexFormula;

    @MockBean
    FormulaClient client;

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "10, 22",
            "9, 2",
            "999, 222",
    })
    void calculate(int input, int expected) {
        Mockito.when(client.requestAnswer(any(Integer.class))).thenReturn(2);
        var result = complexFormula.calculate(input);
        Assertions.assertEquals(expected, result);
    }
}
