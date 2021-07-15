package academy.everyonecodes.java.steampurchases;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public PurchaseService(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public Purchase save(Purchase purchase) {
        String username = purchase.getUser();
        String gameName = purchase.getGame();

        Optional<User> oUser = userRepository.findByUsername(username);
        if (oUser.isEmpty()) {
            return purchase;
        }
        Optional<Game> oGame = gameRepository.findByName(gameName);
        if (oGame.isEmpty()) {
            return purchase;
        }
        User user = oUser.get();
        Game game = oGame.get();

        var games = user.getGames();
        games.add(game);
        userRepository.save(user);
        gameRepository.save(game);
        return purchase;
    }
}
