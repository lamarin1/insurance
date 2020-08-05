package projects.insurance.service;

import projects.insurance.domain.entities.User;
import projects.insurance.domain.serviceModels.UserServiceModel;

import java.util.List;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    User findByUsername(String username);

    List<UserServiceModel> findAllUsers();

    UserServiceModel editUser(UserServiceModel userServiceModel, String oldPassword);
}
