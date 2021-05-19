package academy.everyonecodes.java.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mocky/texts")
public class MockyTextsEndpoint {
    private final RestTemplate restTemplate;
    private final String getOneUrl;
    private final String getArrayUrl;

    public MockyTextsEndpoint(RestTemplate restTemplate, @Value("${mocky.getOneUrl}") String getOneUrl, @Value("${mocky.getArrayUrl}") String getArrayUrl) {
        this.restTemplate = restTemplate;
        this.getOneUrl = getOneUrl;
        this.getArrayUrl = getArrayUrl;
    }

    @GetMapping("/1")
    public String getOneText() {
        return restTemplate.getForObject(getOneUrl, String.class);
    }

    @GetMapping("/2")
    public String[] getArray() {
        return restTemplate.getForObject(getArrayUrl, String[].class);
    }
}
