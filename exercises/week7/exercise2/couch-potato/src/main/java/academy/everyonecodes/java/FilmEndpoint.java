package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {
    private final FilmService service;

    public FilmEndpoint(FilmService service) {
        this.service = service;
    }

    @GetMapping
    public List<Film> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Film save(@Valid @RequestBody Film film) {
        return service.save(film);
    }
}
