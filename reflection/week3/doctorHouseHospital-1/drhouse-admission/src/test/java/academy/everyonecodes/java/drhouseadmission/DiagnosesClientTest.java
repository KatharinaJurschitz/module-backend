package academy.everyonecodes.java.drhouseadmission;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DiagnosesClientTest {
    @Autowired
    DiagnosesClient diagnosesClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${url}")
    String url;

    @Test
    void send() {
        Patient tom = new Patient("Tom", "headache");
        Mockito.when(diagnosesClient.send(tom)).thenReturn(tom);
        diagnosesClient.send(tom);
        Mockito.verify(restTemplate).postForObject(url, tom, Patient.class);
    }
}
