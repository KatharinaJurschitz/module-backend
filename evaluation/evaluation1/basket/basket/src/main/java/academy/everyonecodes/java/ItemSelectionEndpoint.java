package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemselections")
public class ItemSelectionEndpoint {
    private final Basket basket;

    public ItemSelectionEndpoint(Basket basket) {
        this.basket = basket;
    }

    @PostMapping
    void postItem(@RequestBody ItemSelection itemSelection) {
        basket.addSummary(itemSelection);
    }
}
