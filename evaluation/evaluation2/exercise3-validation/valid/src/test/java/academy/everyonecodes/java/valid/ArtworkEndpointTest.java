package academy.everyonecodes.java.valid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtworkEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ArtworkRepository repository;

    String url = "/artworks";

    @Test
    void post() {
        Artwork artwork = new Artwork("Painting", new Rating(4));

        var result = restTemplate.postForObject(url, artwork, Artwork.class);
        Mockito.verify(repository).save(artwork);
        Assertions.assertEquals(artwork, result);
    }

    @Test
    void post_notValidRating() {
        Artwork artwork = new Artwork("Painting", new Rating(6));

        restTemplate.postForObject(url, artwork, Artwork.class);
        Mockito.verify(repository).save(artwork);
    }

    @Test
    void post_notValidName() {
        Artwork artwork = new Artwork( new Rating(3));

        restTemplate.postForObject(url, artwork, Artwork.class);
        Mockito.verify(repository).save(artwork);
    }
}
