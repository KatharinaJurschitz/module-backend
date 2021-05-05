package academy.everyonecodes.java.rockscissorspaper;

import java.util.Scanner;

public record Human(MoveUtils moveUtils) implements Player {

    @Override
    public Move play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What will be your next move? -> " + moveUtils.getMoves());
        String answer = scanner.nextLine();
        return moveUtils.getOne(answer);
    }

    @Override
    public boolean wantsToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play again? (true/false)");
        return scanner.nextBoolean();
    }
}
