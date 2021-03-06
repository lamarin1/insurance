package projects.insurance.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private HomeAddress address;
    private List<InsurancePolicy> policies;

    public Client() {
    }

    public Client(String firstName,
                  String lastName,
                  String phoneNumber) {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToOne
    public HomeAddress getAddress() {
        return address;
    }

    public void setAddress(HomeAddress address) {
        this.address = address;
    }

    @OneToMany
    public List<InsurancePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<InsurancePolicy> policies) {
        this.policies = policies;
    }
}