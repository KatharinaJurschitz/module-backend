package academy.everyonecodes.java.steampurchases;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public List<Game> findAll() {
        return repository.findAll();
    }
}
