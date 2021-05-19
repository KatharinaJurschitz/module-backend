package academy.everyonecodes.java.trickster;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CupsClient {
    private final RestTemplate restTemplate;
    @Value("${cups}") private final List<String> cups = new ArrayList<>();

    public CupsClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean checkForCoin(int cupNumber) {
        String url = cups.get(cupNumber);
        return restTemplate.getForObject(url, Boolean.class);
    }

    public void addCoin(int cupNumber) {
        String url = cups.get(cupNumber);
        restTemplate.put(url, Boolean.class);
    }

    public void removeCoin(int cupNumber) {
        String url = cups.get(cupNumber);
        restTemplate.delete(url);
    }

    public int numberOfCups() {
        return cups.size();
    }
}
