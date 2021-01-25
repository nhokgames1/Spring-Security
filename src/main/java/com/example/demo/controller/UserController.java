package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user !=null) {
            User newUser = userService.add(user);
            return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping
    public  ResponseEntity<List<User>> getUser(){
        List<User> userList = (List<User>) userRepository.findAll();
        return  ResponseEntity.ok(userList);
    }
}
