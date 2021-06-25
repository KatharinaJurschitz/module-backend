package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final PatientService service;

    public PatientEndpoint(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public PatientDTO createInvoice(@RequestBody PatientDTO dto) {
        return service.createInvoice(dto);
    }
}
