package tech.mushonnip.ars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.mushonnip.ars.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
