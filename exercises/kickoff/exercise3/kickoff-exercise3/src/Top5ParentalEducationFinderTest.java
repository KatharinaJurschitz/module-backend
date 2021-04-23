import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Top5ParentalEducationFinderTest {
    private Top5ParentalEducationFinder finder = new Top5ParentalEducationFinder();

    @Test
    void find() {
        List<String> result = finder.find();
        List<String> expected = List.of("associate's degree", "some college",
                "bachelor's degree", "some college", "some college");
        Assertions.assertLinesMatch(expected, result);
    }
}
