import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class ActivityParser {
    public Optional<MonitoredData> parseLine(String line) {
        String[] splitLine = line.split("\t\t");

        if (splitLine.length != 3) {
            return Optional.empty();
        }

        String activity = splitLine[2].toUpperCase().replace("/", "_").trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return Optional.of(new MonitoredData(
                LocalDateTime.parse(splitLine[0], formatter),
                LocalDateTime.parse(splitLine[1], formatter),
                Activity.valueOf(activity)));
    }
}
