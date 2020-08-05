package projects.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.insurance.domain.entities.HomeAddress;

import java.util.List;

public interface HomeAddressRepository extends JpaRepository<HomeAddress, Long> {

    List<HomeAddress> findAll();

    HomeAddress findByAddress(String address);

}

