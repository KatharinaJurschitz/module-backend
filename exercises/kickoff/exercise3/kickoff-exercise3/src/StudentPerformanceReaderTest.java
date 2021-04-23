import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class StudentPerformanceReaderTest {
    private StudentPerformanceReader reader = new StudentPerformanceReader();

    @Test
    void read() {
        List<StudentPerformance> result = reader.read();
        StudentPerformance expected = new StudentPerformance("female",
                "master's degree",50,53,58);
        Assertions.assertTrue(result.contains(expected));
    }
}
