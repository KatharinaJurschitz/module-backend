package academy.everyonecodes.java.mocky;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mocky/postcards")
public class MockyPostcardsEndpoint {
    private final RestTemplate restTemplate;
    private final String getPostcardOne;
    private final String getPostcardTwo;

    public MockyPostcardsEndpoint(RestTemplate restTemplate, @Value("${mocky.getPostcardOne}") String getPostcardOne, @Value("${mocky.getPostcardTwo}") String getPostcardTwo) {
        this.restTemplate = restTemplate;
        this.getPostcardOne = getPostcardOne;
        this.getPostcardTwo = getPostcardTwo;
    }

    @GetMapping("/1")
    public Postcard getFirstPostcard() {
        return restTemplate.getForObject(getPostcardOne, Postcard.class);
    }

    @GetMapping("/2")
    public List<Postcard> getSecondPostcard() {
        List<Postcard> output = new ArrayList<>();
        output.add(restTemplate.getForObject(getPostcardOne, Postcard.class));
        output.add(restTemplate.getForObject(getPostcardTwo, Postcard.class));
        return output;
    }
}
