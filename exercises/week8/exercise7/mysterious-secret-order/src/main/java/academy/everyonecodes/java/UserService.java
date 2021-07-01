package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final String apprenticeRole;

    public UserService(UserRepository repository, PasswordEncoder encoder, @Value("${apprentice.authorities}") String apprenticeRole) {
        this.repository = repository;
        this.encoder = encoder;
        this.apprenticeRole = apprenticeRole;
    }

    public User postUser(User user) {
        String password = user.getPassword();
        String encoded = encoder.encode(password);
        user.setPassword(encoded);
        return repository.save(user);
    }

    public List<User> getApprentices() {
        return repository.findByAuthorities(apprenticeRole);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
