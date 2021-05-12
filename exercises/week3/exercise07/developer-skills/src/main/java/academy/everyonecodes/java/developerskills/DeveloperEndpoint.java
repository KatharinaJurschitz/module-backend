package academy.everyonecodes.java.developerskills;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {
    private DeveloperService developerService;

    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    List<Developer> getAll() {
        return developerService.findAll();
    }

    @GetMapping("/skills/{skills}")
    List<Developer> getSkills(@PathVariable String skills) {
        return developerService.findBy(skills);
    }
}
