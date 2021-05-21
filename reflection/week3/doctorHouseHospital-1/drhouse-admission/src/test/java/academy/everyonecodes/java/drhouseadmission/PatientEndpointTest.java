package academy.everyonecodes.java.drhouseadmission;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    Admission admission;

    @Test
    void post() {
        String url = "/patients";
        Patient lisa = new Patient("Lisa", "fatigue, appear pale");
        restTemplate.postForObject(url, lisa, Patient.class);
        Mockito.verify(admission).admit(lisa);
    }
}
