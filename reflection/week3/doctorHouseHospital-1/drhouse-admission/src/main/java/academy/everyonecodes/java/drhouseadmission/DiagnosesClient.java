package academy.everyonecodes.java.drhouseadmission;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnosesClient {
    private final RestTemplate restTemplate;
    private final String url;

    public DiagnosesClient(RestTemplate restTemplate, @Value("${url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Patient send(@RequestBody Patient patient) {
        return restTemplate.postForObject(url, patient, Patient.class);
    }
}
