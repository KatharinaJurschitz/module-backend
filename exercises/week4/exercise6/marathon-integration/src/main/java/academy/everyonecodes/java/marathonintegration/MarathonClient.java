package academy.everyonecodes.java.marathonintegration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class MarathonClient {
    private final RestTemplate restTemplate;

    public MarathonClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Runner getWinner() {
        String url = "/runners/winner";
        return restTemplate.getForObject(url, Runner.class);
    }

    public Runner postRunner(@RequestBody Runner runner) {
        String url = "/runners";
        return restTemplate.postForObject(url, runner, Runner.class);
    }
}
