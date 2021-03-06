package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.UserRequest;
import dk.keadat21v2.movieman.dto.UserResponse;
import dk.keadat21v2.movieman.entitites.User;
import dk.keadat21v2.movieman.error.Client4xxException;
import dk.keadat21v2.movieman.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserResponse(user)).collect(Collectors.toList());
    }

    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findById(username).orElseThrow();
        return new UserResponse(user);
    }

    public boolean validateUser(UserRequest body) {
        if(userRepository.existsById(body.getUsername())) {
            User user = userRepository.getById(body.getUsername());
            PasswordEncoder pw = User.getPasswordEncoder();
            return pw.matches(body.getPassword(), user.getPassword());
        }
        return false;
    }

    public UserResponse addUser(UserRequest body) {
        if (userRepository.existsById(body.getUsername())) {
            throw new Client4xxException("Username is already taken");
        }

        User user = new User(body);
        user = userRepository.save(user);
        return new UserResponse(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findById(username).orElseThrow();
        userRepository.delete(user);
    }
}
