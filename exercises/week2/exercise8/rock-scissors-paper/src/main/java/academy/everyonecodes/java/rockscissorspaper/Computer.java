package academy.everyonecodes.java.rockscissorspaper;

import java.util.List;
import java.util.Random;

public record Computer(List<Move> moves) implements Player {

    @Override
    public Move play() {
        Random random = new Random();
        return moves.get(random.nextInt(moves.size()));
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
