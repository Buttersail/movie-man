package dk.keadat21v2.movieman.services;

import dk.keadat21v2.movieman.dto.UserResponse;
import dk.keadat21v2.movieman.entitites.User;
//import dk.keadat21v2.movieman.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

//    UserRepository userRepository;

    public List<UserResponse> getUser() {
//        List<User> users = userRepository.findAll();
//        return users.stream().map(user -> new UserResponse(user.getUsername())).collect(Collectors.toList());
        return null;
    }

    public UserResponse getUserByUsername(String username) {
//        User user = userRepository.findById(username).orElseThrow();
//        return new UserResponse(username);
        return null;

    }

    public void deleteUser(String username) {
//        User user = userRepository.findById(username).orElseThrow();
//        userRepository.delete(user);
    }
}
