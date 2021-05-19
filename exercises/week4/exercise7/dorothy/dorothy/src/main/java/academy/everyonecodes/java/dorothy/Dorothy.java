package academy.everyonecodes.java.dorothy;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Dorothy {
    private final RestTemplate restTemplate;

    public Dorothy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String interact() {
        String urlWizard = "http://localhost:9001/wizard";
        String urlHome = restTemplate.getForObject(urlWizard, String.class);
        String location = restTemplate.getForObject(urlHome, String.class);
        return "My home is " + location;
    }
}
