package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdService {

    @Autowired
    private NumberGenerator numberGenerator;

    public String generate() {
        String id = "HELLO" + numberGenerator.get();
        return  id;
    }
}

@Component
class NumberGenerator {
    public int get() {
        int randomNumber = new Random().nextInt(10);
        return randomNumber;
    }
}