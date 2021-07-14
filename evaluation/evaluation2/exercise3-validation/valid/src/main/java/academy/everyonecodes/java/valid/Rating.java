package academy.everyonecodes.java.valid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    @Min(1)
    @Max(5)
    private int stars;

    public Rating(@Min(1) @Max(5) int stars) {
        this.stars = stars;
    }

    public Rating() {
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return stars == rating.stars && Objects.equals(id, rating.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stars);
    }
}

