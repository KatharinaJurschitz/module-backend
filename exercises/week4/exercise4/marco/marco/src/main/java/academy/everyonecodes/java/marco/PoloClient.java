package academy.everyonecodes.java.marco;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PoloClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9001/polo";

    public PoloClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestAnswer(String text) {
        return restTemplate.postForObject(url, text, String.class);
    }
}
