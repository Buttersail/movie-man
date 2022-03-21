package dk.keadat21v2.movieman.controller;

import dk.keadat21v2.movieman.dto.UserRequest;
import dk.keadat21v2.movieman.dto.UserResponse;
import dk.keadat21v2.movieman.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/users")
public class UserController {


    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getUser());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable String id){
        return userService.getUserByUsername(id);
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest body) {
        return userService.addUser(body);
    }

    @DeleteMapping("/id")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

}
