package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentEndpoint {
    private final TreatmentService service;

    public TreatmentEndpoint(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Treatment> findAll() {
        return service.findAll();
    }

    @GetMapping("/{uuid}")
    public List<Treatment> findByUuid(@PathVariable String uuid) {
        return service.findByUuid(uuid);
    }
}
