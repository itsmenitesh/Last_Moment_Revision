package Practice.UsersRepository;

import Practice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    boolean existsByEmail(String email);

    Optional<Users> findByEmail(String email);
}
