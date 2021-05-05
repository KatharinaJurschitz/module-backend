package academy.everyonecodes.java.emergencynumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FireEmergencyTest {
    @Autowired
    FireEmergency fireEmergency;

    @Test
    void getName() {
        var result = fireEmergency.getName();
        var expected = "Fire brigade";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        var result = fireEmergency.getTelephone();
        var expected = 122;
        Assertions.assertEquals(expected, result);
    }
}
