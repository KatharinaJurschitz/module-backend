package academy.everyonecodes.java.drivers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {
    private final DriverService service;

    public DriverEndpoint(DriverService service) {
        this.service = service;
    }

    @PostMapping
    public Driver processDriver(@RequestBody Driver driver) {
        return service.processDriver(driver);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    public Driver findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    public void setAvailable(@RequestBody @PathVariable String id) {
        service.setAvailable(id);
    }

    @PutMapping("/{id}/unavailable")
    @Secured("ROLE_DRIVER")
    public void setUnavailable(@RequestBody @PathVariable String id) {
        service.setUnavailable(id);
    }
}
