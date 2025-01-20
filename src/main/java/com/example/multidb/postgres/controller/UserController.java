package com.example.multidb.postgres.controller;


import com.example.multidb.postgres.entity.User;
import com.example.multidb.postgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("postgresUserController")
@RequestMapping("/api/v1/postgres")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }
}
