package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String concatData(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()){
            return "Hello " + user.get().getName();
        }
        throw new UserNotFoundException(name);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
