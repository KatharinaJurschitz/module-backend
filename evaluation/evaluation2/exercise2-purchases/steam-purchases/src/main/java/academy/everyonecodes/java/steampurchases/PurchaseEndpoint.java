package academy.everyonecodes.java.steampurchases;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class PurchaseEndpoint {
    private final PurchaseService service;

    public PurchaseEndpoint(PurchaseService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_APP")
    public Purchase save(@RequestBody Purchase purchase) {
        return service.save(purchase);
    }
}
