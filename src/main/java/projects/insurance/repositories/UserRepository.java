package projects.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.insurance.domain.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}