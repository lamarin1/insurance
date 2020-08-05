package projects.insurance.domain.bindingsModels;

import org.hibernate.validator.constraints.Length;

public class UserRegisterModel {

    private String username;
    private String password;
    private String confirmPassword;

    public UserRegisterModel() {
    }

    @Length(min = 2, max = 20, message = "Username length is not correct!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 2, max = 20, message = "Password length is not correct!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
