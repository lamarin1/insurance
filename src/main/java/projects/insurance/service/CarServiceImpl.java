package projects.insurance.service;

import org.springframework.stereotype.Service;
import projects.insurance.domain.entities.Car;
import projects.insurance.repositories.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Car findByDKN() {
        return null;
    }
}
