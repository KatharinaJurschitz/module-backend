package academy.everyonecodes.java.trickster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TricksterEndpoint {
    private final Trickster trickster;

    public TricksterEndpoint(Trickster trickster) {
        this.trickster = trickster;
    }

    @GetMapping("/play")
    String play() {
        return trickster.play();
    }

    @GetMapping("/choose/{cup}")
    boolean hasCoin(@PathVariable int cup) {
        return trickster.hasCoin(cup);
    }
}
