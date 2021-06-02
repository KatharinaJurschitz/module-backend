package academy.everyonecodes.java;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@ConfigurationProperties("users")
public class UserStore {
    private List<User> users;

    public UserStore(List<User> users) {
        this.users = users;
    }

    public UserStore() {}

    void setUsers(List<User> users) {
        this.users = users;
    }

    public Optional<User> getUser(String email) {
        return users.stream()
                .filter(x -> x.getEmail().equals(email))
                .findFirst();
    }

}
