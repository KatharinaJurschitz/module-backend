package academy.everyonecodes.java.complexformula;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class FormulaClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8080/formula";

    public FormulaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer requestAnswer(int input) {
        return restTemplate.postForObject(url, input, Integer.class);
    }
}
