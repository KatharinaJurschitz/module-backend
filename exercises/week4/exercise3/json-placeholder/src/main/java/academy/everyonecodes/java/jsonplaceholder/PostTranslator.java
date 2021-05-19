package academy.everyonecodes.java.jsonplaceholder;

import org.springframework.stereotype.Service;

@Service
public class PostTranslator {
    public PostDTO postToPostDTO(Post post) {
        return new PostDTO(post.getTitle(), post.getContent(), post.getUser(), post.getIdentifier());
    }

    public Post postDTOToPost(PostDTO postDTO) {
        return new Post(postDTO.getTitle(), postDTO.getBody(), postDTO.getUserId(), postDTO.getId());
    }
}
