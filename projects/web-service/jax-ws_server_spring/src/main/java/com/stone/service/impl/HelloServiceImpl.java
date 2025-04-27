package com.stone.service.impl;

import com.stone.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + ", welcome to server!";
    }
}
