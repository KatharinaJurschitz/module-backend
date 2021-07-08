package academy.everyonecodes.java.drivers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DriverRepository extends MongoRepository<Driver, String> {

    Optional<Driver> findOneByUsername(String username);

}
