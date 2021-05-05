package academy.everyonecodes.java.rockscissorspaper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoveUtils {
    private final List<Move> moves;

    public MoveUtils(List<Move> moves) {
        this.moves = moves;
    }

    public String getMoves() {
        return moves.stream()
                .map(Move::getName)
                .collect(Collectors.joining(","));
    }

    public Move getOne(String moveName) {
        Optional<Move> output = moves.stream()
                .filter(x -> x.getName().equalsIgnoreCase(moveName))
                .findFirst();
        return output.orElseThrow();
    }
}
