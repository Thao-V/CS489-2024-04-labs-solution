package cs489.lab.ads.repository;

import cs489.lab.ads.model.User;
import jakarta.persistence.Index;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);
}
