package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommendations")
public class RecommendationEndpoint {
    private final RecommendationService service;

    public RecommendationEndpoint(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/{userUuid}")
    Movie[] get(@PathVariable String userUuid) {
        return service.get(userUuid);
    }
}
