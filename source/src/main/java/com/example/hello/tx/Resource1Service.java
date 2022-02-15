package com.example.hello.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Resource1Service {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void DoSomeThing() {

    }
}
