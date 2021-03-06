package projects.insurance.domain.viewModels;

import projects.insurance.domain.entities.HomeAddress;

public class ClientViewModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private HomeAddress address;

    public ClientViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HomeAddress getAddress() {
        return address;
    }

    public void setAddress(HomeAddress address) {
        this.address = address;
    }
}