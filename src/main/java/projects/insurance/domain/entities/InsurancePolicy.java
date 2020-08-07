package projects.insurance.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "policies")
public class InsurancePolicy extends BaseEntity{

    private String policyNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double premium;
    private Double insuredValue;
    private Client client;
    private Car car;

    public InsurancePolicy() {
    }

    @Column(name = "policy_number", unique = true, nullable = false)
    @NotEmpty
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @Column(name = "start_date", nullable = false)
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date", nullable = false)
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Column(name = "premium", nullable = false)
    @Min(1)
    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    @Column(name = "value", nullable = false)
    @Min(1)
    public Double getInsuredValue() {
        return insuredValue;
    }

    public void setInsuredValue(Double insuredValue) {
        this.insuredValue = insuredValue;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}