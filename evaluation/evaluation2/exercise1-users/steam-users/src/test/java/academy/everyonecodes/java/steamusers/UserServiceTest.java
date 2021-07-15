package academy.everyonecodes.java.steamusers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {
    @Autowired
    UserService service;

    @MockBean
    UserRepository repository;

    @MockBean
    PasswordEncoder encoder;

    @Test
    void saveFindsExistingUser() {
        String username = "username";
        User user = new User(username, "password");
        Mockito.when(repository.findOneByUsername(username)).thenReturn(Optional.of(user));

        service.save(user);

        Mockito.verify(repository).findOneByUsername(username);
        Mockito.verifyNoMoreInteractions(repository);
    }

    @Test
    void saveCreatesNewUser() {
        String username = "username";
        Mockito.when(repository.findOneByUsername(username)).thenReturn(Optional.empty());
        User user = new User(username, "password");

        service.save(user);

        Mockito.verify(repository).findOneByUsername(username);
        Mockito.verify(repository).save(user);
    }

}
