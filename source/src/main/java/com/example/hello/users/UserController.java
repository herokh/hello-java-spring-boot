package com.example.hello.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserGateway userGateway;

    @GetMapping("/call/{id}")
    public UserResponse callUserApi(@PathVariable int id){
        return userGateway.getUserById(id);
    }

}
