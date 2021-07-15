package academy.everyonecodes.java.steampurchases;

import java.util.Objects;

public class Purchase {
    private String user;
    private String game;

    public Purchase(String user, String game) {
        this.user = user;
        this.game = game;
    }

    public Purchase() {}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(user, purchase.user) && Objects.equals(game, purchase.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, game);
    }
}
