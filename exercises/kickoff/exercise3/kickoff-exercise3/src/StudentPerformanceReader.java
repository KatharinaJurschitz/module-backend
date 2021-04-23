import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentPerformanceReader {
    public List<StudentPerformance> read() {
        StudentPerformanceParser parser = new StudentPerformanceParser();
        Path path = Path.of("src/students-performance.csv");

        List<StudentPerformance> output = new ArrayList<>();
        try {
            output = Files.lines(path)
                    .skip(1)
                    .map(parser::parseLine)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("error reading file");
            e.printStackTrace();
        }
        return output;
    }
}
