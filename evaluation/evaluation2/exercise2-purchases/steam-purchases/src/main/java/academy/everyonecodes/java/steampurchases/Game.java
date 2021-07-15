package academy.everyonecodes.java.steampurchases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;

    public Game(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Game() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.price, price) == 0 && Objects.equals(id, game.id) && Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
