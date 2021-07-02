package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
