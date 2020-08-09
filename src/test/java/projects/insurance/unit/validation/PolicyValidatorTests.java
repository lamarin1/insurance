package projects.insurance.unit.validation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.entities.Car;
import projects.insurance.domain.entities.Client;
import projects.insurance.domain.entities.HomeAddress;
import projects.insurance.domain.entities.InsurancePolicy;
import projects.insurance.repositories.PolicyRepository;
import projects.insurance.validation.PolicyAddValidator;

@RunWith(MockitoJUnitRunner.class)
public class PolicyValidatorTests {

    @Mock
    PolicyRepository repository;

    @Mock
    Car car;

    @Mock
    HomeAddress address;

    @Mock
    InsurancePolicy policy;

    Client client;

    PolicyAddValidator validator;

    AddPolicyBindingModel model;


    @Before
    public void init() {
        validator = new PolicyAddValidator(repository);
        model = new AddPolicyBindingModel();
        client = new Client("Andrei", "Petrov", "0896457511");
    }

    @Test
    public void validate_Register_Policy() {

        this.repository.saveAndFlush(policy);

        Assert.assertNotNull(this.repository.findAll());
    }

//    @Test
//    public void validate_Register_PolicyWithIncorrectData() {
//
//        Errors errors = new BeanPropertyBindingResult(model, "validPolicy");
//
//        validator.validate(model, errors);
//
//        Assert.assertTrue(errors.hasErrors());
//    }


}
