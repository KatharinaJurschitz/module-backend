import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Optional;
import java.util.stream.Stream;

class PictureNameExtractorTest {
    private PictureNameExtractor extractor = new PictureNameExtractor();

    @ParameterizedTest
    @MethodSource("inputData")
    void extract_Test(String input, Optional<String> expected) {
        var result = extractor.extract(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(
                        "01222013SunshinePic.jpg", Optional.of("sunshine")
                ),
                Arguments.of(
                        "24122019SnowflakePic.jpg", Optional.of("snowflake")
                ),
                Arguments.of(
                "01082003Dereks-BirthdayPic.jpg", Optional.of("dereks birthday")
                ),
                Arguments.of(
                        "01012021Pic.jpg", Optional.of("")
                ),
                Arguments.of(
                        "0101202Pic.jpg", Optional.empty()
                )
        );
    }
}