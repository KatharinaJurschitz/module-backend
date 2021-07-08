package academy.everyonecodes.java.rides;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {
    private final DriverService service;

    public DriverEndpoint(DriverService service) {
        this.service = service;
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public Driver save(@RequestBody Driver driver) {
        return service.save(driver);
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    public List<Driver> findAll() {
        return service.findAll();
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    public Ride linkToDriver(@RequestBody Ride ride, @PathVariable Long id) {
        return service.linkToDriver(ride, id);
    }
}
