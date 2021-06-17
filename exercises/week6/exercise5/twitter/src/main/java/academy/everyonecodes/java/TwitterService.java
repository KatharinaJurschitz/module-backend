package academy.everyonecodes.java;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TwitterService {
    private final TweetRepository repository;

    public TwitterService(TweetRepository repository) {
        this.repository = repository;
    }

    public List<Tweet> getAll() {
        return repository.findByOrderByTimestampDesc();
    }

    public List<Tweet> getUserTweets(String user) {
        return repository.findByUserOrderByTimestampDesc(user);
    }

    public Tweet postTweet(Tweet tweet) {
        tweet.setComments(new ArrayList<>());
        tweet.setTimestamp(LocalDateTime.now());
        return repository.save(tweet);
    }

    public void like(String id) {
        Optional<Tweet> oTweet = repository.findById(id);
        if  (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            int likes = tweet.getLikes();
            tweet.setLikes(likes + 1);
            repository.save(tweet);
        }
    }

    public void comment(String id, String comment) {
        Optional<Tweet> oTweet = repository.findById(id);
        if  (oTweet.isPresent()) {
            Tweet tweet = oTweet.get();
            tweet.getComments().add(comment);
            repository.save(tweet);
        }
    }
}
