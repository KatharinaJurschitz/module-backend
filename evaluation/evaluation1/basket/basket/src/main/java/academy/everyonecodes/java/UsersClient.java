package academy.everyonecodes.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class UsersClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9001/users";

    public UsersClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    User getUser(String email) {
        String userUrl = url + "/" + email;
        return restTemplate.getForObject(userUrl, User.class);
    }
}
