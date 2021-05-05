package academy.everyonecodes.java.rockscissorspaper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class JudgeTest {
    private final Judge judge = new Judge();

    @ParameterizedTest
    @MethodSource("inputData")
    void judge(Move input1, Move input2, String expected) {
        var result = judge.judge(input1, input2);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        new Move("paper", "rock"), new Move("rock", "scissors"), "You win!"
                ),
                Arguments.of(
                        new Move("rock", "scissors"), new Move("scissors", "paper"), "You win!"
                ),
                Arguments.of(
                        new Move("scissors", "paper"), new Move("paper", "rock"), "You win!"
                ),
                Arguments.of(
                        new Move("scissors", "paper"), new Move("scissors", "paper"), "It's a tie!"
                ),
                Arguments.of(
                        new Move("paper", "rock"), new Move("paper", "rock"), "It's a tie!"
                ),
                Arguments.of(
                        new Move("rock", "scissors"), new Move("rock", "scissors"), "It's a tie!"
                ),
                Arguments.of(
                        new Move("rock", "scissors"), new Move("paper", "rock"), "You lose!"
                ),
                Arguments.of(
                        new Move("paper", "rock"), new Move("scissors", "paper"), "You lose!"
                ),
                Arguments.of(
                        new Move("scissors", "paper"), new Move("rock", "scissors"), "You lose!"
                )
        );
    }
}
