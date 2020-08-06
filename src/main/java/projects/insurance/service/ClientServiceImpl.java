package projects.insurance.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.serviceModels.ClientServiceModel;
import projects.insurance.domain.viewModels.ClientViewModel;
import projects.insurance.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addClient(ClientServiceModel model) {
        Client client = this.modelMapper.map(model, Client.class);

        this.clientRepository.saveAndFlush(client);
    }

    @Override
    public void deleteClient(Long id) {
        this.clientRepository.deleteById(id);
    }

    //TODO find method
    @Override
    public List<Client> findAllClients() {
        return this.clientRepository.findAll();
    }

    @Override
    public ClientViewModel findByFirstName(String firstName) {
        return this.clientRepository.findClientByFirstName(firstName);
    }

    @Override
    public ClientViewModel findByLastName(String lastName) {
        return this.clientRepository.findClientByLastName(lastName);
    }
}
