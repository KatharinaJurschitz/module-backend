package academy.everyonecodes.java.drhousediagnoses;

import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {
    private final DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        String diagnose = drHouse.diagnose(patient);
        System.out.println("Patient with the symptoms: " + patient.getSymptoms() + "; diagnosed with: " + diagnose);
        patient.setDiagnosis(diagnose);
        return patient;
    }
}
