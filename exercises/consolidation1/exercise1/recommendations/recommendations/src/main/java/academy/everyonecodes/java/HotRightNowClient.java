package academy.everyonecodes.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class HotRightNowClient {
    private final RestTemplate restTemplate;
    private final String url;

    public HotRightNowClient(RestTemplate restTemplate,@Value("${url.hot}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Movie[] getHots() {
        return restTemplate.getForObject(url, Movie[].class);
    }
}
