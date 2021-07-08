package academy.everyonecodes.java.drivers;

import java.util.Objects;
import java.util.Set;

public class Driver {
    private String id;
    private String username;
    private String password;
    private String car;
    private Set<String> authorities;
    private boolean available;

    public Driver(String username, String password, String car, boolean available) {
        this.username = username;
        this.password = password;
        this.car = car;
        this.available = available;
    }

    public Driver() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}
