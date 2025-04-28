package com.stone;

import com.stone.entity.Car;
import com.stone.entity.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

public class ClientTest {

    @Test
    public void testService() {
        // 通过WebClient对象远程调用服务端
        // 1. 创建WebClient对象
        WebClient webClient = WebClient.create("http://localhost:10081/ws/userService/userService/user");
        User user = new User();
        user.setId(10);
        user.setUsername("stone");
        user.setCity("BeiJing");
        Car car = new Car();
        car.setId(10);
        car.setCarName("BMW");
        car.setPrice(1000000.00);
        user.getCars().add(car);
        // 设置传输的数据类型，默认类型是 text/xml
        // webClient.type(MediaType.APPLICATION_XML);
        webClient.type(MediaType.APPLICATION_JSON);
        // 2. 调用服务端方法
        webClient.post(user);
    }

    @Test
    public void testGetUserById() {
        WebClient webClient = WebClient.create("http://localhost:10081/ws/userService/userService/user/1");
        // webClient.accept(MediaType.APPLICATION_XML);
        User user = webClient.get(User.class);
        System.out.println(user);
    }
}
