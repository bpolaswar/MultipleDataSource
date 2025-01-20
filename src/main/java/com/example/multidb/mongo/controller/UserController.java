package com.example.multidb.mongo.controller;

import com.example.multidb.mongo.entity.User;
import com.example.multidb.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mongoUserController")
@RequestMapping("/api/v1/mongo")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }
}
