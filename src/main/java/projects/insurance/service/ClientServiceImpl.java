package projects.insurance.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import projects.insurance.domain.bindingsModels.EditClientBindingModel;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.entities.HomeAddress;
import projects.insurance.domain.serviceModels.ClientServiceModel;
import projects.insurance.domain.viewModels.ClientViewModel;
import projects.insurance.repositories.ClientRepository;
import projects.insurance.repositories.HomeAddressRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private final HomeAddressRepository homeAddressRepository;

    public ClientServiceImpl(ClientRepository clientRepository,
                             ModelMapper modelMapper,
                             HomeAddressRepository homeAddressRepository) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.homeAddressRepository = homeAddressRepository;
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

    @Override
    public ClientViewModel findClientById(Long id) {
        return this.modelMapper
                .map(this.clientRepository.findById(id), ClientViewModel.class);
    }

    @Override
    public void editClient(String phoneNumber, EditClientBindingModel model) {

        Client client = this.modelMapper
                .map(this.clientRepository.findByPhoneNumber(phoneNumber), Client.class);

        HomeAddress address = new HomeAddress();

        address = this.homeAddressRepository.findByAddress(model.getAddress().toString()) == null
                ? this.modelMapper.map(model, HomeAddress.class)
                : this.homeAddressRepository.findByAddress(model.getAddress().toString());

        this.modelMapper.map(model, HomeAddress.class);

        client.setFirstName(model.getFirstName());
        client.setLastName(model.getLastName());
        client.setPhoneNumber(model.getPhoneNumber());
        client.setAddress(address);

        System.out.println();

        this.homeAddressRepository.saveAndFlush(address);
        this.clientRepository.saveAndFlush(client);
    }
}
