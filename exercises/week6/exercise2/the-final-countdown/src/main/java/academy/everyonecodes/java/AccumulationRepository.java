package academy.everyonecodes.java;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccumulationRepository extends MongoRepository<Accumulation, String> {
}
