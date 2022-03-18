package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.UserRequest;
import dk.keadat21v2.movieman.dto.UserResponse;
import dk.keadat21v2.movieman.entitites.User;
import dk.keadat21v2.movieman.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    UserRepository userRepository;

    public List<UserResponse> getUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserResponse(user.getUsername())).collect(Collectors.toList());
    }

    public UserResponse getUserByUsername(String username) {
        User user = userRepository.findById(username).orElseThrow();
        return new UserResponse(username);
    }

    public UserResponse addUser(UserRequest body) {
        if (userRepository.existsById(body.getUsername())) {
            System.out.println("ERROR, Username is taken");
        }

        User user = new User(body);
        user = userRepository.save(user);
        return new UserResponse(user.getUsername());
    }

    public void deleteUser(String username) {
        User user = userRepository.findById(username).orElseThrow();
        userRepository.delete(user);
    }
}
