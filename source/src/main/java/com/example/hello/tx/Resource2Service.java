package com.example.hello.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Resource2Service {

    @Transactional
    public void DoSomeThing() {

    }
}
