package academy.everyonecodes.java.drivers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {
    private final DriverRepository repository;
    private final PasswordEncoder encoder;

    public DriverService(DriverRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Driver processDriver(Driver driver) {
        Optional<Driver> oDriver = repository.findOneByUsername(driver.getUsername());
        if (oDriver.isPresent()) {
            Driver driver1 = oDriver.get();
            driver1.setAuthorities(Set.of("ROLE_DRIVER"));
            repository.save(driver1);
            return driver1;
        }
        driver.setAuthorities(Set.of("ROLE_DRIVER"));
        driver.setAvailable(false);
        String password = driver.getPassword();
        String encoded = encoder.encode(password);
        driver.setPassword(encoded);
        repository.save(driver);
        return repository.findById(driver.getId()).get();
    }

    public Driver findById(String id) {
        Optional<Driver> oDriver = repository.findById(id);
        if (oDriver.isEmpty()) {
            return null;
        }
        return oDriver.get();
    }

    public void setAvailable(String id) {
        Driver driver;
        Optional<Driver> oDriver = repository.findById(id);
        if (oDriver.isPresent()) {
            driver = oDriver.get();
            driver.setAvailable(true);
            repository.save(driver);
        }
    }

    public void setUnavailable(String id) {
        Driver driver;
        Optional<Driver> oDriver = repository.findById(id);
        if (oDriver.isPresent()) {
            driver = oDriver.get();
            driver.setAvailable(false);
            repository.save(driver);
        }
    }
}
