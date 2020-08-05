package projects.insurance.service;

import projects.insurance.domain.serviceModels.ClientServiceModel;
import projects.insurance.domain.viewModels.ClientViewModel;

import java.util.List;

public interface ClientService {

    void addClient(ClientServiceModel model);

    void deleteClient(Long id);

    List<ClientViewModel> findAllClients();

    ClientViewModel findByFirstName(String firstName);

    ClientViewModel findByLastName(String lastName);
}
