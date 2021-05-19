package academy.everyonecodes.java.trickster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TricksterTest {
    @Autowired
    Trickster trickster;

    @MockBean
    CupsClient client;

    @MockBean
    Random random;

    @Test
    void play() {
        Mockito.when(random.nextInt(2)).thenReturn(0);
        trickster.play();
//        var result = trickster.hasCoin(0);
//        Assertions.assertTrue(result);
        Mockito.verify(random).nextInt(2);
    }
}
