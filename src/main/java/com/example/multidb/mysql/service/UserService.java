package com.example.multidb.mysql.service;

import com.example.multidb.mysql.entity.User;
import com.example.multidb.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mysqlUserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }
}
