package academy.everyonecodes.java.singaporereconstruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class BuildingReconstructionCandidateAnalyserTest {
    @Autowired
    BuildingReconstructionCandidateAnalyser analyser;

    @Test
    void findCandidates() {
        Building appartments = new Building("Eliptic Appartments", LocalDate.of(1993, 5, 3), false);
        Building amusementpark = new Building("New World Amusement Park", LocalDate.of(1991, 8, 1), false);

        var result = analyser.findCandidates();
        var expected = List.of(appartments, amusementpark);
        Assertions.assertEquals(expected, result);
    }
}
