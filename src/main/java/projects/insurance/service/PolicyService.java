package projects.insurance.service;

import projects.insurance.domain.bindingsModels.AddPolicyBindingModel;
import projects.insurance.domain.bindingsModels.EditPolicyBidingModel;
import projects.insurance.domain.entities.InsurancePolicy;
import projects.insurance.domain.viewModels.PolicyViewModel;

import java.util.List;

public interface PolicyService {

    List<PolicyViewModel> findAll();

    void addPolicy(AddPolicyBindingModel model);

    InsurancePolicy findPolicyByNumber(String number);

    List<InsurancePolicy> findAllByClientId(Long id);

    void editPolicy(String policyNumber, EditPolicyBidingModel model);

    void deletePolicyByNumber(String number);

    void deletePolicyByID(Long id);
}
