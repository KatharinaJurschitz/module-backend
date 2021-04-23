import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileContentReverser {
    public void reverse(Path inputRootPath, Path outputRootPath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(inputRootPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.reverse(lines);

        try {
            Files.write(outputRootPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
