package academy.everyonecodes.java;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("store")
public class MovieStore {
    private List<Movie> movies;

    void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllHotRightNow() {
        return movies;
    }
}
