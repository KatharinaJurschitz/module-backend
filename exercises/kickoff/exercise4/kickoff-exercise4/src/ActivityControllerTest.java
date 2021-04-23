import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class ActivityControllerTest {
    private final ActivityController controller = ActivityController.getInstance();

    @ParameterizedTest
    @MethodSource("showNumberOfDaysInLog")
    void showNumberOfDaysInLog_Test(List<MonitoredData> input, long expected) {
        var result = controller.showNumberOfDaysInLog(input);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> showNumberOfDaysInLog() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<MonitoredData> list1 = List.of(new MonitoredData(LocalDateTime.parse("2019-11-28 20:20:55", formatter),
                        LocalDateTime.parse("2019-11-28 20:20:59", formatter),Activity.SNACK),
                new MonitoredData(LocalDateTime.parse("2019-11-30 10:21:24", formatter),
                        LocalDateTime.parse("2019-11-30 10:23:36", formatter),Activity.TOILETING),
                new MonitoredData(LocalDateTime.parse("2019-12-29 10:21:24", formatter),
                        LocalDateTime.parse("2019-12-30 10:23:36", formatter),Activity.TOILETING));
        return Stream.of(
                Arguments.of(
                        list1, 32
                )
        );
    }
}
