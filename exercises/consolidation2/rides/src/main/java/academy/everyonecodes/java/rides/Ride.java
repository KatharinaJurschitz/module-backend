package academy.everyonecodes.java.rides;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Driver driver;
    private double distance;
    private double price;

    public Ride(double distance, double price) {
        this.distance = distance;
        this.price = price;
    }

    public Ride(Driver driver, double distance, double price) {
        this.driver = driver;
        this.distance = distance;
        this.price = price;
    }

    public Ride() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return Double.compare(ride.distance, distance) == 0 && Double.compare(ride.price, price) == 0 && Objects.equals(id, ride.id) && Objects.equals(driver, ride.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driver, distance, price);
    }
}
