package academy.everyonecodes.java.valid;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Artwork {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @Valid
    @OneToOne
    private Rating rating;

    public Artwork(@NotEmpty String name, Rating rating) {
        this.name = name;
        this.rating = rating;
    }

    public Artwork() {}

    public Artwork(Rating rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artwork artwork = (Artwork) o;
        return Objects.equals(id, artwork.id) && Objects.equals(name, artwork.name) && Objects.equals(rating, artwork.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rating);
    }
}

