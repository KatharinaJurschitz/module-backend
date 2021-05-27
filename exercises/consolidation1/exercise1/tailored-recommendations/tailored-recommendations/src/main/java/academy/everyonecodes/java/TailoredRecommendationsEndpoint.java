package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tailoredrecommendations")
public class TailoredRecommendationsEndpoint {
    private TailoredRecommendationsStore store;

    public TailoredRecommendationsEndpoint(TailoredRecommendationsStore store) {
        this.store = store;
    }

    @GetMapping("/{userUuid}")
    Movie[] getRecommendations(@PathVariable String userUuid) {
        return store.getRecommendations(userUuid).stream()
                .map(TailoredRecommendation::getMovie)
                .toArray(Movie[]::new);
    }

    @PostMapping
    TailoredRecommendation postNewRecommendation(@RequestBody TailoredRecommendation recommendation) {
        return store.postNewRecommendation(recommendation);
    }
}
