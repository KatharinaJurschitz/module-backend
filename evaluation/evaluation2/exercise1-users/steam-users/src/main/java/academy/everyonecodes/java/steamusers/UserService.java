package academy.everyonecodes.java.steamusers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final String[] authorities;

    public UserService(UserRepository repository, PasswordEncoder encoder, @Value("${users.authorities}") String[] authorities) {
        this.repository = repository;
        this.encoder = encoder;
        this.authorities = authorities;
    }

    public User save(User user) {
        return repository.findOneByUsername(user.getUsername())
                .orElseGet(() -> create(user));
    }

    private User create(User user) {
        String encoded = encoder.encode(user.getPassword());
        user.setPassword(encoded);
        user.setAuthorities(authorities);
        return repository.save(user);
    }

}
