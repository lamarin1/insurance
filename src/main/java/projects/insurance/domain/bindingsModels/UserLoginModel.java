package projects.insurance.domain.bindingsModels;

import org.hibernate.validator.constraints.Length;

public class UserLoginModel {

    private String username;
    private String password;

    public UserLoginModel() {
    }

    @Length(min = 2, max = 20, message = "Username length is not correct!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 2, message = "Password is incorrect!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
