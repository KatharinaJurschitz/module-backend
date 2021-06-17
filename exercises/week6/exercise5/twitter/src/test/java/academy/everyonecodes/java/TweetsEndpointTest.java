package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TweetsEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    TwitterService service;

    String url = "/tweets";

    @Test
    void getAll() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(service.getAll()).thenReturn(List.of(tweet));
        restTemplate.getForObject(url, Tweet[].class);
        Mockito.verify(service).getAll();
    }

    @Test
    void getUserTweets() {
        String nUrl = url + "/user/test";
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(service.getUserTweets("test")).thenReturn(List.of(tweet));
        restTemplate.getForObject(nUrl, Tweet[].class);
        Mockito.verify(service).getUserTweets("test");
    }

    @Test
    void postTweet() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(service.postTweet(tweet)).thenReturn(tweet);
        restTemplate.postForObject(url, tweet, Tweet.class);
        Mockito.verify(service).postTweet(tweet);
    }

    @Test
    void like() {
        String nUrl = url + "/test/likes";
        Tweet tweet = new Tweet("test", "test");
        restTemplate.put(nUrl, Void.class);
        Mockito.verify(service).like("test");
    }

    @Test
    void comment() {
        String nUrl = url + "/test/comments";
        Tweet tweet = new Tweet("test", "test");
        tweet.setComments(new ArrayList<>());
        restTemplate.put(nUrl, Void.class);
        Mockito.verify(service).comment("test", null);;
    }
}
