package academy.everyonecodes.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SummaryCalculatorTest {
    @Autowired
    SummaryCalculator calculator;

    @MockBean
    UsersClient client;

    @Test
    void getSummaryNotPremium() {
        User user = new User("test", "test");
        ItemSelection item = new ItemSelection("test", "test", 1.0);
        Summary expected = new Summary("test", "test", 1.0, 2.5, 3.5);
        Mockito.when(client.getUser("test")).thenReturn(user);
        var result = calculator.getSummary(item);
        Assertions.assertEquals(expected, result);
        Mockito.verify(client).getUser("test");
    }

    @Test
    void getSummaryPremium() {
        User user = new User("test", "premium account");
        ItemSelection item = new ItemSelection("test", "test", 1.0);
        Summary expected = new Summary("test", "test", 1.0, 0.0, 1.0);
        Mockito.when(client.getUser("test")).thenReturn(user);
        var result = calculator.getSummary(item);
        Assertions.assertEquals(expected, result);
        Mockito.verify(client).getUser("test");
    }
}
