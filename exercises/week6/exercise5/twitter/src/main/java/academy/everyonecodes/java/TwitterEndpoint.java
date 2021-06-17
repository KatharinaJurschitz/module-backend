package academy.everyonecodes.java;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TwitterEndpoint {
    private final TwitterService service;

    public TwitterEndpoint(TwitterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tweet> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/{user}")
    public List<Tweet> getUserTweets(@PathVariable String user) {
        return service.getUserTweets(user);
    }

    @PostMapping
    public Tweet postTweet(@RequestBody Tweet tweet) {
        return service.postTweet(tweet);
    }

    @PutMapping("/{id}/likes")
    public void like(@PathVariable String id) {
        service.like(id);
    }

    @PutMapping("/{id}/comments")
    public void comment(@PathVariable String id, String comment) {
        service.comment(id, comment);
    }
}
