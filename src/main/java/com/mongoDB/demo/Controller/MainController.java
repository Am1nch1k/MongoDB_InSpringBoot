package com.mongoDB.demo.Controller;

import com.mongoDB.demo.entity.User;
import com.mongoDB.demo.repository.UserRepository;
import com.mongoDB.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id")
    public String getUserById(@RequestParam String id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get().getId() : "User not found";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
