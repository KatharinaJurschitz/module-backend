package academy.everyonecodes.java.rides;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final DriverRepository repository;
    private final RideRepository rideRepository;

    public DriverService(DriverRepository repository, RideRepository rideRepository) {
        this.repository = repository;
        this.rideRepository = rideRepository;
    }

    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Ride linkToDriver(Ride ride, Long id) {
        Driver driver = repository.findById(id).orElse(null);
        ride.setDriver(driver);
        rideRepository.save(ride);
        return ride;
    }
}
