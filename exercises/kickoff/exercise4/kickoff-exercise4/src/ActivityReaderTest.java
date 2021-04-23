import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ActivityReaderTest {
    private ActivityReader reader = new ActivityReader();

    @Test
    void read() {
        List<MonitoredData> result = reader.read();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        MonitoredData expected = new MonitoredData(LocalDateTime.parse("2019-11-28 20:20:55", formatter),
                LocalDateTime.parse("2019-11-28 20:20:59", formatter),Activity.SNACK);
        Assertions.assertTrue(result.contains(expected));
    }
}
