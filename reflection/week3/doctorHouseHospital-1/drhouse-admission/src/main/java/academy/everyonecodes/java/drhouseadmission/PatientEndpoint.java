package academy.everyonecodes.java.drhouseadmission;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PatientEndpoint {
    private final Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }

    @PostMapping("/patients")
    //@Secured("ROLE_USER")
    public Patient post(@RequestBody Patient patient) {
        return admission.admit(patient);
    }
}
