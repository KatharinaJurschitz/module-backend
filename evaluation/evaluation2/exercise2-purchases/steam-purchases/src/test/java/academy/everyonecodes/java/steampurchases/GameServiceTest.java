package academy.everyonecodes.java.steampurchases;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GameServiceTest {
    @Autowired
    GameService service;

    @MockBean
    GameRepository repository;

    @Test
    void findAll() {
        service.findAll();
        Mockito.verify(repository).findAll();
    }
}
