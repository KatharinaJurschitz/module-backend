import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Top5ParentalEducationFinder {
    public List<String> find() {
        StudentPerformanceReader reader = new StudentPerformanceReader();

        List<StudentPerformance> performances = reader.read();
        List<String> output = performances.stream()
                .sorted(Comparator.comparing(StudentPerformance::getMathScore).reversed())
                .limit(5)
                .map(StudentPerformance::getParentalEducation)
                .collect(Collectors.toList());

        return output;
    }
}
