package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

@Service
public class Nurse {
    private final TreatmentService service;

    public Nurse(TreatmentService service) {
        this.service = service;
    }

    public void saveTreatmentToPatient(Patient patient) {
        patient.setTreatment("spend one day in the hospital bed");
        service.saveTreatmentToPatient(patient);
    }
}
