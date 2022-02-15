package com.example.hello.tx;

import com.example.hello.User;
import com.example.hello.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoTxService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Resource1Service resource1Service;

    @Autowired
    private Resource2Service resource2Service;

    @Transactional
    public void callRepository() {
        createNewUsers();
        resource1Service.DoSomeThing();
        resource2Service.DoSomeThing();
    }

    private void createNewUsers() {
        User user1 = new User(1, "user 1");
        User user2 = new User(2, "user 2");
        User user3 = new User(3, "user 3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

}
