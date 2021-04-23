import java.util.Optional;

public class PictureNameExtractor {
    public Optional<String> extract(String fileName) {
        if (fileName.length() < 15) {
            return Optional.empty();
        }
        return Optional.of(fileName
                .substring(8, fileName.length() -7)
                .toLowerCase()
                .replace("-", " "));
    }
}
