package projects.insurance.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import projects.insurance.domain.entities.User;
import projects.insurance.domain.serviceModels.UserServiceModel;
import projects.insurance.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper
                .map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, User.class))
                .orElse(null);
    }

    //TODO find methods


    @Override
    public List<UserServiceModel> findAllUsers() {
        return null;
    }

    @Override
    public UserServiceModel editUser(UserServiceModel userServiceModel,
                                     String oldPassword) {
        return null;
    }
}
