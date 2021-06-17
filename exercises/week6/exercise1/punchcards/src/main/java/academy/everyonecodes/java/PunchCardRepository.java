package academy.everyonecodes.java;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PunchCardRepository extends MongoRepository<PunchCard, String> {
}
