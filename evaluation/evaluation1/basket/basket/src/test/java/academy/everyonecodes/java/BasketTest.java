package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BasketTest {
    @Autowired
    Basket basket;

    @MockBean
    SummaryCalculator calculator;

    @Test
    void addSummary() {
        ItemSelection item = new ItemSelection("test", "test", 1.0);
        Summary summary = new Summary("test", "test", 1.0, 2.5, 3.5);
        Mockito.when(calculator.getSummary(item)).thenReturn(summary);
        basket.addSummary(item);
        Mockito.verify(calculator).getSummary(item);
    }

    @Test
    void getSummaries() {
        var result = basket.getSummaries();
        Assertions.assertEquals(0, result.size());
    }
}
