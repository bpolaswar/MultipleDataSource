package com.example.multidb.mongo.service;


import com.example.multidb.mongo.entity.User;
import com.example.multidb.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mongoUserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }
}
