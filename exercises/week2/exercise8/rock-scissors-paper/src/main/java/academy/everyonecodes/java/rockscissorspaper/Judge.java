package academy.everyonecodes.java.rockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Judge {
    public String judge(Move move1, Move move2) {
        if (move1.getDefeats().equalsIgnoreCase(move2.getName())) {
            return "You win!";
        } else if (move2.getDefeats().equalsIgnoreCase(move1.getName())) {
            return "You lose!";
        } else {
            return "It's a tie!";
        }
    }
}
