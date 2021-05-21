package academy.everyonecodes.java.drhousediagnoses;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {
    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String diagnose(Patient patient) {
        return diagnoses.stream()
                .filter(x -> patient.getSymptoms().equalsIgnoreCase(x.getSymptoms()))
                .map(Diagnosis::getName)
                .findFirst()
                .orElse("lupus");
    }
}
