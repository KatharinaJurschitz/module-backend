package academy.everyonecodes.java;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountdownRepository extends MongoRepository<Countdown, String> {
}
