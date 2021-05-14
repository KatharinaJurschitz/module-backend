package academy.everyonecodes.java.drhouseadmission;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class AdmissionTest {
    @Autowired
    private Admission admission;

    @Test
    void admit() {
        var result = admission.admit(new Patient("Lisa", "headache"));
        Assertions.assertFalse(result.getUuid().isEmpty());
    }
}
