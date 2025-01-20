package com.example.multidb.postgres.service;


import com.example.multidb.postgres.entity.User;
import com.example.multidb.postgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("postgresUseService")
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User addUser(User user) {
        return userRepository.save(user);
    }
}
