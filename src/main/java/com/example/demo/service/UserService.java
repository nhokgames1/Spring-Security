package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User add(User user){
        String password=user.getPassword();
        password = BCrypt.hashpw(password,BCrypt.gensalt(12));
        user.setPassword(password);
        User data = userRepository.save(user);
        return data;
    }
}
