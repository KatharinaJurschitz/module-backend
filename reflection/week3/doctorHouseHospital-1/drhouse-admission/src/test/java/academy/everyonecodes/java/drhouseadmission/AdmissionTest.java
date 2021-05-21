package academy.everyonecodes.java.drhouseadmission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class AdmissionTest {
    @Autowired
    private Admission admission;

    @MockBean
    UUIDProvider uuidProvider;

    @MockBean
    DiagnosesClient diagnosesClient;

    @Test
    void admit() {
        Patient lisa = new Patient("Lisa", "headache");
        Mockito.when(diagnosesClient.send(lisa)).thenReturn(lisa);
        var result = admission.admit(lisa);
        Mockito.verify(diagnosesClient).send(lisa);
    }
}
