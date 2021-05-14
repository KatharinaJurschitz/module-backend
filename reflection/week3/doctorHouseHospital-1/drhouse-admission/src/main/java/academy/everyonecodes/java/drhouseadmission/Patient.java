package academy.everyonecodes.java.drhouseadmission;

import java.util.Objects;

public class Patient {
    private String uuid;
    private String name;
    private String symptom;

    public Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
    }

    public String getUuid() {
        return uuid;
    }

    void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(uuid, patient.uuid) && Objects.equals(name, patient.name) && Objects.equals(symptom, patient.symptom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, symptom);
    }
}
