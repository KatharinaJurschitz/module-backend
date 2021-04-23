import java.util.List;

public class GenderRatioCalculator {
    public String calculate() {
        StudentPerformanceReader reader = new StudentPerformanceReader();
        List<StudentPerformance> performances = reader.read();

        long amountFemales = performances.stream()
                .filter(x -> x.getGender().equals("female"))
                .count();

        long amountMales = performances.stream()
                .filter(x -> x.getGender().equals("male"))
                .count();

        return amountFemales + ":" + amountMales;
    }
}
