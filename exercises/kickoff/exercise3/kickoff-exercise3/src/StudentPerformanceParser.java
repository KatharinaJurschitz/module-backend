public class StudentPerformanceParser {
    public StudentPerformance parseLine(String line) {
        String[] splitLine = line.split(";");

        return new StudentPerformance(splitLine[0], splitLine[1],
                Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]),
                Integer.parseInt(splitLine[4]));
    }
}
