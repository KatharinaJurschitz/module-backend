package academy.everyonecodes.java.cup;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cup")
public class CupEndpoint {
    private final Cup cup;

    public CupEndpoint(Cup cup) {
        this.cup = cup;
    }

    @GetMapping
    boolean requestIfCoin() {
        return cup.checkForCoin();
    }

    @PutMapping
    void putCoin() {
        cup.addCoin();
    }

    @DeleteMapping
    void removeCoin() {
        cup.removeCoin();
    }
}
