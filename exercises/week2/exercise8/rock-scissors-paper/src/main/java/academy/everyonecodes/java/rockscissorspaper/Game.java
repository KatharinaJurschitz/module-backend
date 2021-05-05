package academy.everyonecodes.java.rockscissorspaper;

import org.springframework.stereotype.Service;

@Service
public class Game {
    private final Player player1;
    private final Player player2;
    private final Judge judge;

    public Game(Player player1, Player player2, Judge judge) {
        this.player1 = player1;
        this.player2 = player2;
        this.judge = judge;
    }

    public void play() {
        do {
            Move humanMove = player1.play();
            Move computerMove = player2.play();
            System.out.println("The computer chose: " + computerMove.getName());
            System.out.println(judge.judge(humanMove, computerMove));
        } while (player1.wantsToPlayAgain() && player2.wantsToPlayAgain());
    }
}
