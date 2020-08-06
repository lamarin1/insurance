package projects.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.insurance.domain.entities.InsurancePolicy;
import projects.insurance.domain.viewModels.PolicyViewModel;

import java.util.List;

public interface PolicyRepository extends JpaRepository<InsurancePolicy, Long> {

    InsurancePolicy findByPolicyNumber(String number);

    PolicyViewModel findByClientFirstName(String firstName);

    PolicyViewModel findByClientLastName(String lastName);

    void deleteInsurancePolicyByPolicyNumber(String number);

    List<InsurancePolicy> findAllByClientId(long id);
}
