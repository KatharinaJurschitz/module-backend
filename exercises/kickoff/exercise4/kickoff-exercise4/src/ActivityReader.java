import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActivityReader {
    public List<MonitoredData> read() {
        ActivityParser parser = new ActivityParser();
        Path inputPath = Path.of("src/Activities.txt");
        List<MonitoredData> output = new ArrayList<>();
        try {
            output = Files.lines(inputPath)
                    .map(parser::parseLine)
                    .flatMap(Optional::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("error reading file");
            e.printStackTrace();
        }

        return output;
    }
}
