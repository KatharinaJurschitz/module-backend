package academy.everyonecodes.java.developerskills;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {
    private List<Developer> developers;

    public DeveloperService(List<Developer> developers) {
        this.developers = developers;
    }

    public DeveloperService() {}

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    public List<Developer> findBy(String requestedSkills) {
        List<String> splitSkills = Arrays.asList(requestedSkills.split(" "));
        splitSkills = splitSkills.stream()
                .map(x -> x.replace(",", ""))
                .collect(Collectors.toList());
        List<String> finalSplitSkills = splitSkills;
        return developers.stream()
                .filter(x -> x.getSkills().containsAll(finalSplitSkills))
                .collect(Collectors.toList());
    }
}
