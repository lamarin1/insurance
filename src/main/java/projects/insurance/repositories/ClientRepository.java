package projects.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.viewModels.ClientViewModel;

public interface ClientRepository extends JpaRepository<Client, Long> {

    ClientViewModel findClientByFirstName(String firstName);

    ClientViewModel findClientByLastName(String lastName);

    Client findByPhoneNumber(String phoneNumber);

}