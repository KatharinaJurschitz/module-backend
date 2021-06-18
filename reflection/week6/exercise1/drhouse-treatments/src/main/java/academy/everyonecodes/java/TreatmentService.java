package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    private final TreatmentRepository repository;

    public TreatmentService(TreatmentRepository repository) {
        this.repository = repository;
    }

    public List<Treatment> findAll() {
        return repository.findAll();
    }

    public List<Treatment> findByUuid(String uuid) {
        return repository.findByUuid(uuid);
    }

    public void saveTreatmentToPatient(Patient patient) {
        Treatment treatment = new Treatment(patient.getUuid(), patient.getName(),
                patient.getSymptoms(), patient.getDiagnosis(), patient.getTreatment());
        repository.save(treatment);
    }
}
