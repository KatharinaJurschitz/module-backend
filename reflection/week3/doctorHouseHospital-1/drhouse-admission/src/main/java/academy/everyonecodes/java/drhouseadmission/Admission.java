package academy.everyonecodes.java.drhouseadmission;

import org.springframework.stereotype.Service;

@Service
public class Admission {
    private final UUIDProvider provider;
    private final DiagnosesClient client;

    public Admission(UUIDProvider provider, DiagnosesClient client) {
        this.provider = provider;
        this.client = client;
    }

    public Patient admit(Patient patient) {
        provider.provideUUID(patient);
        return client.send(patient);
    }
}
