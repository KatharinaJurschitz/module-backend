import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class FileContentReverserTest {
    private FileContentReverser reverser = new FileContentReverser();

    @Test
    void reverse_Test() {
        Path inputPath = Path.of("src/kickoff files/lines.txt");
        Path outputPath = Path.of("src/kickoff files/lines-reversed.txt");
        Path expectedPath = Path.of("src/kickoff files/lines-reversed_expected.txt");

        reverser.reverse(inputPath, outputPath);

        List<String> result = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        try {
            result = Files.readAllLines(outputPath);
            expected = Files.readAllLines(expectedPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertLinesMatch(expected, result);
    }
}