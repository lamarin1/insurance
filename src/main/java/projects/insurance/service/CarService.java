package projects.insurance.service;

import projects.insurance.domain.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findByDKN();
}
