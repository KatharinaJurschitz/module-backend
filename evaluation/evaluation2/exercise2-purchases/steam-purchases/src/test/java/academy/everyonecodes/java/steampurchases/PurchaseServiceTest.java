package academy.everyonecodes.java.steampurchases;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PurchaseServiceTest {
    @Autowired
    PurchaseService service;

    @MockBean
    UserRepository userRepository;

    @MockBean
    GameRepository gameRepository;

    @Test
    void linkDoesNotFindGame() {
        User user = new User();
        Mockito.when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));
        Mockito.when(gameRepository.findByName("gamename")).thenReturn(Optional.empty());

        service.save(new Purchase("username", "gamename"));

        Mockito.verify(gameRepository).findByName("gamename");
        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verifyNoMoreInteractions(gameRepository);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    void linkDoesNotFindUser() {
        Mockito.when(userRepository.findByUsername("username")).thenReturn(Optional.empty());

        service.save(new Purchase("username", "gamename"));

        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verifyNoMoreInteractions(userRepository);
        Mockito.verifyNoInteractions(gameRepository);
    }

    @Test
    void linkDoesNotFindEither() {
        Mockito.when(userRepository.findByUsername("username")).thenReturn(Optional.empty());

        service.save(new Purchase("username", "gamename"));

        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verifyNoMoreInteractions(userRepository);
        Mockito.verifyNoInteractions(gameRepository);
    }

    @Test
    void linkFindsBoth() {
        User user = new User("username", "password", "ROLE_USER");
        Mockito.when(userRepository.findByUsername("username")).thenReturn(Optional.of(user));
        Game game = new Game("gamename", 9.99);
        Mockito.when(gameRepository.findByName("gamename")).thenReturn(Optional.of(game));

        service.save(new Purchase("username", "gamename"));

        Mockito.verify(gameRepository).findByName("gamename");
        Mockito.verify(gameRepository).save(game);
        Mockito.verify(userRepository).findByUsername("username");
        Mockito.verify(userRepository).save(user);
    }

}
