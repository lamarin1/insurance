package projects.insurance.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private String DKN;
    private String chassis;
    private String year;
    private List<InsurancePolicy> policies;

    public Car() {
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "DKN", nullable = false, unique = true)
    public String getDKN() {
        return DKN;
    }

    public void setDKN(String DKN) {
        this.DKN = DKN;
    }

    @Column(name = "VIN", nullable = false)
    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    @Column(name = "year", nullable = false)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @OneToMany
    public List<InsurancePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<InsurancePolicy> policies) {
        this.policies = policies;
    }
}