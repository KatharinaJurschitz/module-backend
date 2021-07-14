package academy.everyonecodes.java.valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/artworks")
public class ArtworkEndpoint {
    private final ArtworkRepository repository;
    private final RatingRepository ratingRepository;

    public ArtworkEndpoint(ArtworkRepository repository, RatingRepository ratingRepository) {
        this.repository = repository;
        this.ratingRepository = ratingRepository;
    }

    @PostMapping
    public Artwork post(@Valid @RequestBody Artwork artwork) {
        return repository.save(artwork);
    }
}