package academy.everyonecodes.java.steampurchases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String authorities;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();;

    public User(String username, String password, String authorities, Set<Game> games) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.games = games;
    }

    public User(String username, String authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public User(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(authorities, user.authorities) && Objects.equals(games, user.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities, games);
    }
}
