package academy.everyonecodes.java;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmService {
    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<Film> getAll() {
        return repository.findAll();
    }

    public Film save(Film film) {
        return repository.save(film);
    }
}
