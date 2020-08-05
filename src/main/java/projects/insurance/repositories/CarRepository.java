package projects.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.insurance.domain.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findCarByDKN(String dkn);
}