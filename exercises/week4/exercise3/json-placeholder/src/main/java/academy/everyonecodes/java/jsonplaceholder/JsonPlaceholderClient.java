package academy.everyonecodes.java.jsonplaceholder;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

@Controller
public class JsonPlaceholderClient {
    private final RestTemplate restTemplate;
    private final PostTranslator postTranslator;
    private final String url = "http://jsonplaceholder.typicode.com/posts";
    private final List<Post> posts;

    public JsonPlaceholderClient(RestTemplate restTemplate, PostTranslator postTranslator, List<Post> posts) {
        this.restTemplate = restTemplate;
        this.postTranslator = postTranslator;
        this.posts = posts;
    }

    public List<Post> getAll() {
        PostDTO[] responseDTO = restTemplate.getForObject(url, PostDTO[].class);
        return Stream.of(responseDTO)
                .map(postTranslator::postDTOToPost)
                .collect(toList());
    }

    public Post getOne(int id) {
        String oneItemUrl = this.url + "/" + id;
        PostDTO responseDTO = restTemplate.getForObject(oneItemUrl, PostDTO.class);
        return postTranslator.postDTOToPost(responseDTO);
    }

    public Post post(Post post) {
        PostDTO requestDTO = postTranslator.postToPostDTO(post);
        PostDTO responseDTO = restTemplate.postForObject(url, requestDTO, PostDTO.class);
        return postTranslator.postDTOToPost(responseDTO);
    }

    public Post modify(int id, Post modifiedPost) {
        PostDTO requestDTO = postTranslator.postToPostDTO(modifiedPost);
        restTemplate.put(url + "/" + id, requestDTO);
        return modifiedPost;
    }

    public void deleteOne(int id) {
        String specificItemUrl = url + "/" + id;
        restTemplate.delete(specificItemUrl);
    }
}
