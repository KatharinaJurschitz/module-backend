package academy.everyonecodes.java;

import java.util.Arrays;
import java.util.Objects;

public class SchoolUser {
    private String username;
    private String password;
    private String[] authorities;

    public SchoolUser() {}

    public SchoolUser(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolUser user = (SchoolUser) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Arrays.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, password);
        result = 31 * result + Arrays.hashCode(authorities);
        return result;
    }
}
