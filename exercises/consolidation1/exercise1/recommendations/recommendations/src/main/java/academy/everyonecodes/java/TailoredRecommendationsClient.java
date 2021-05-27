package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class TailoredRecommendationsClient {
    private final RestTemplate restTemplate;
    private final String url;

    public TailoredRecommendationsClient(RestTemplate restTemplate, @Value("${url.tailored}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Movie[] getRecomms(String userUuid) {
        String userUrl = url + "/" + userUuid;
        return restTemplate.getForObject(userUrl, Movie[].class);
    }
}
