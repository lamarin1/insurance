package projects.insurance.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.bindingsModels.EditPolicyBidingModel;
import projects.insurance.domain.entities.Car;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.entities.HomeAddress;
import projects.insurance.domain.entities.InsurancePolicy;
import projects.insurance.domain.viewModels.PolicyViewModel;
import projects.insurance.repositories.CarRepository;
import projects.insurance.repositories.ClientRepository;
import projects.insurance.repositories.HomeAddressRepository;
import projects.insurance.repositories.PolicyRepository;


import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final HomeAddressRepository homeAddressRepository;
    private final ModelMapper modelMapper;

    public PolicyServiceImpl(PolicyRepository policyRepository,
                             ClientRepository clientRepository,
                             CarRepository carRepository,
                             HomeAddressRepository homeAddressRepository,
                             ModelMapper modelMapper) {
        this.policyRepository = policyRepository;
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
        this.homeAddressRepository = homeAddressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PolicyViewModel> findAll() {

        return this.policyRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, PolicyViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPolicy(AddPolicyBindingModel model) {

        InsurancePolicy policy = this.modelMapper.map(model, InsurancePolicy.class);

        HomeAddress address = new HomeAddress();
        Car car = new Car();
        Client client = new Client();

        address = this.homeAddressRepository.findByAddress(model.getAddress()) == null
                ? this.modelMapper.map(model, HomeAddress.class)
                : this.homeAddressRepository.findByAddress(model.getAddress());

        car = this.carRepository.findCarByDKN(model.getDkn()) == null
                ? this.modelMapper.map(model, Car.class)
                : this.carRepository.findCarByDKN(model.getDkn());

        client = this.clientRepository.findByPhoneNumber(model.getPhoneNumber()) == null
                ? this.modelMapper.map(model, Client.class)
                : this.clientRepository.findByPhoneNumber(model.getPhoneNumber());

        client.setAddress(address);
        policy.setCar(car);
        policy.setClient(client);
        policy.setStartDate(model.getDate());
        policy.setEndDate(model.getDate().plusYears(1L));

        this.homeAddressRepository.saveAndFlush(address);
        this.carRepository.saveAndFlush(car);
        this.clientRepository.saveAndFlush(client);
        this.policyRepository.saveAndFlush(policy);
    }

    @Override
    public InsurancePolicy findPolicyByNumber(String number) {
        return this.policyRepository.findByPolicyNumber(number);
    }

    @Override
    @Transient
    public void editPolicy(String policyNumber, EditPolicyBidingModel model) {

        InsurancePolicy policy = this.policyRepository.findByPolicyNumber(policyNumber);

        policy = this.modelMapper.map(model, InsurancePolicy.class);

        HomeAddress address = new HomeAddress();
        Car car = new Car();
        Client client = new Client();

        address = this.homeAddressRepository.findByAddress(model.getAddress()) == null
                ? this.modelMapper.map(model, HomeAddress.class)
                : this.homeAddressRepository.findByAddress(model.getAddress());

        car = this.carRepository.findCarByDKN(model.getDkn()) == null
                ? this.modelMapper.map(model, Car.class)
                : this.carRepository.findCarByDKN(model.getDkn());

        client = this.clientRepository.findByPhoneNumber(model.getPhoneNumber()) == null
                ? this.modelMapper.map(model, Client.class)
                : this.clientRepository.findByPhoneNumber(model.getPhoneNumber());

        System.out.println();

        client.setAddress(address);
        policy.setCar(car);
        policy.setClient(client);
        policy.setStartDate(model.getDate());
        policy.setEndDate(model.getDate().plusYears(1L));

        this.homeAddressRepository.saveAndFlush(address);
        this.carRepository.saveAndFlush(car);
        this.clientRepository.saveAndFlush(client);
        this.policyRepository.saveAndFlush(policy);
    }

    @Override
    @Transactional
    public void deletePolicyByNumber(String number) {
        this.policyRepository.deleteInsurancePolicyByPolicyNumber(number);
    }

    @Override
    public void deletePolicyByID(Long id) {
        this.policyRepository.deleteById(id);
    }


}
