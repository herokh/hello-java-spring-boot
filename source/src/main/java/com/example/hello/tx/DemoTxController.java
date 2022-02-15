package com.example.hello.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTxController {

    @Autowired
    private DemoTxService demoTxService;

    @GetMapping("/calltx")
    @ResponseStatus(HttpStatus.OK)
    public String callTxService() {
        demoTxService.callRepository();
        return "ok";
    }

}
