package projects.insurance.unit.validation;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.entities.Client;
import projects.insurance.repositories.PolicyRepository;
import projects.insurance.validation.PolicyAddValidator;

@RunWith(MockitoJUnitRunner.class)
public class PolicyValidatorTests {

    @Mock
    PolicyRepository repository;

    Client client;

    PolicyAddValidator validator;

    AddPolicyBindingModel model;



    @Before
    public void init(){
        validator = new PolicyAddValidator(repository);
        model = new AddPolicyBindingModel();
        client = new Client("Andrei", "Petrov", "0896457511");
    }

    @Test
    public void validate_PolicyWithCorrectCarData(){

    }







}
