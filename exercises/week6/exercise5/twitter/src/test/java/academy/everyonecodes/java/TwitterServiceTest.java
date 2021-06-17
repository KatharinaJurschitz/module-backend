package academy.everyonecodes.java;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TwitterServiceTest {
    @Autowired
    TwitterService service;

    @MockBean
    TweetRepository repository;

    @Test
    void getAll() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(repository.findByOrderByTimestampDesc()).thenReturn(List.of(tweet));
        service.getAll();
        Mockito.verify(repository).findByOrderByTimestampDesc();
    }

    @Test
    void getUserTweets() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(repository.findByUserOrderByTimestampDesc("test")).thenReturn(List.of(tweet));
        service.getUserTweets("test");
        Mockito.verify(repository).findByUserOrderByTimestampDesc("test");
    }

    @Test
    void postTweet() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(repository.save(tweet)).thenReturn(tweet);
        service.postTweet(tweet);
        Mockito.verify(repository).save(tweet);
    }

    @Test
    void like() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(repository.findById("test")).thenReturn(Optional.of(tweet));
        service.like("test");
        Mockito.verify(repository).findById("test");
        Mockito.verify(repository).save(tweet);
    }

    @Test
    void comment() {
        Tweet tweet = new Tweet("test", "test");
        Mockito.when(repository.findById("test")).thenReturn(Optional.of(tweet));
        tweet.setComments(new ArrayList<>());
        service.comment("test", "test");
        Mockito.verify(repository).findById("test");
        Mockito.verify(repository).save(tweet);
    }
}
