package academy.everyonecodes.java.rides;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String car;

    public Driver(String name, String car) {
        this.name = name;
        this.car = car;
    }

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(name, driver.name) && Objects.equals(car, driver.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, car);
    }
}
