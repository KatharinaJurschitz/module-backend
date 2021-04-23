import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

public class ActivityParserTest {
    private ActivityParser parser = new ActivityParser();

    @ParameterizedTest
    @MethodSource("inputData")
    void parse(String input, Optional<MonitoredData> expected) {
        var result = parser.parseLine(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Stream.of(
                Arguments.of(
                        "2019-11-28 20:20:55\t\t2019-11-28 20:20:59\t\tSnack",
                        Optional.of(new MonitoredData(LocalDateTime.parse("2019-11-28 20:20:55", formatter),
                                LocalDateTime.parse("2019-11-28 20:20:59", formatter),Activity.SNACK))
                ),
                Arguments.of(
                        "2019-11-28 20:20:55\t2019-11-28 20:20:59\t\tSnack",
                        Optional.empty()
                ),
                Arguments.of(
                        "2019-11-28 20:20:55\t\t2019-11-28\t\t20:20:59\t\tSnack",
                        Optional.empty()
                ),
                Arguments.of(
                        "2019-11-28 10:21:24\t\t2019-11-28 10:23:36\t\tToileting",
                        Optional.of(new MonitoredData(LocalDateTime.parse("2019-11-28 10:21:24", formatter),
                                LocalDateTime.parse("2019-11-28 10:23:36", formatter),Activity.TOILETING))
                )
        );
    }
}
