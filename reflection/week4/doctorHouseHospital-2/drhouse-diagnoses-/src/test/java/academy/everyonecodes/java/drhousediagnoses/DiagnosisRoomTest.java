package academy.everyonecodes.java.drhousediagnoses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DiagnosisRoomTest {
    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @Test
    void diagnose() {
        Patient lisa = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Lisa", "fatigue, appear pale");
        Mockito.when(drHouse.diagnose(lisa)).thenReturn("anemia");
        var returnValue = diagnosisRoom.diagnose(lisa);
        Assertions.assertEquals("anemia", returnValue.getDiagnosis());
        Mockito.verify(drHouse).diagnose(lisa);
    }
}
