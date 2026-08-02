package Practice.UsersService;

import Practice.UsersRepository.UsersRepository;
import Practice.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users users) {
        if (usersRepository.existsByEmail(users.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        return usersRepository.save(users);
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public Users getUserByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + email));
    }

    public Users updateUser(String email, Users users) {
        Users user = getUserByEmail(email);
        String updatedEmail = users.getEmail();

        if (!email.equals(updatedEmail) && usersRepository.existsByEmail(updatedEmail)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        user.setName(users.getName());
        user.setEmail(updatedEmail);
        user.setAge(users.getAge());
        user.setGender(users.getGender());
        user.setNumber(users.getNumber());

        return usersRepository.save(user);
    }

    public void deleteUser(String email) {
        usersRepository.delete(getUserByEmail(email));
    }
}
