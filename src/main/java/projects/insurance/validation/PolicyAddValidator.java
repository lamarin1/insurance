package projects.insurance.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.repositories.PolicyRepository;

@Component
public class PolicyAddValidator implements Validator {

    private final PolicyRepository repository;

    @Autowired
    public PolicyAddValidator(PolicyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Object o, Errors errors) {

        AddPolicyBindingModel model = (AddPolicyBindingModel) o;

        if(this.repository.findByPolicyNumber(model.getPolicyNumber()) != null){
            errors.rejectValue("policyNumber", "Policy with this number already exist!");
        }

        if (model.getPolicyNumber() == null) {
            errors.rejectValue("policyNumber", "Policy number can't be empty!");
        }

        if (model.getPhoneNumber().length() < 9 || model.getPhoneNumber() == null) {
            errors.rejectValue("phoneNumber", "Phone number should be correct length between 9 and 15 digits!");
        }

        if (model.getPremium() < 1) {
            errors.rejectValue("premium", "Premium should be a positive number!");
        }

        if (model.getChassis().length() != 17) {
            errors.rejectValue("chassis", "The VIN number should be exactly 17 digits!");
        }

        if (model.getInsuredValue() < 1) {
            errors.rejectValue("insuredValue", "Insured Value can not be empty!");
        }

        if (model.getMake() == null) {
            errors.rejectValue("make", "Car brand can not be empty!");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

}
