package academy.everyonecodes.java.dorothy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DorothyTest {
    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void interact() {
        Mockito.when(restTemplate.getForObject("/wizard", String.class)).thenReturn("Kansas");
        var result = dorothy.interact();
        var expected = "My home is Kansas";
        Assertions.assertEquals(expected, result);
    }
}
