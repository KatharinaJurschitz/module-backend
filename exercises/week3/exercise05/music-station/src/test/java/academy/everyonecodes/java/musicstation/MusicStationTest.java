package academy.everyonecodes.java.musicstation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class MusicStationTest {
    @Autowired
    MusicStation musicStation;

    @ParameterizedTest
    @MethodSource("inputData")
    void testFindBy(String input, List<Song> expected) {
        var result = musicStation.findBy(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("Electronic", List.of(new Song("Windowscene", "Electronic"), new Song("The World Is Mine", "Electronic"))),
                Arguments.of("Psychedelic Rock", List.of(new Song("Si Un Jour", "Psychedelic Rock"), new Song("Tomorrow Never Knows", "Psychedelic Rock"))),
                Arguments.of("Son", List.of(new Song("Chan Chan", "Son")))
        );
    }

    @Test
    void findAll() {
        var result = musicStation.findAll();
        var expected = List.of(new Song("Windowscene", "Electronic"), new Song("The World Is Mine", "Electronic"),
                new Song("Si Un Jour", "Psychedelic Rock"), new Song("Tomorrow Never Knows", "Psychedelic Rock"),
                new Song("Chan Chan", "Son"));
        Assertions.assertEquals(expected, result);
    }
}