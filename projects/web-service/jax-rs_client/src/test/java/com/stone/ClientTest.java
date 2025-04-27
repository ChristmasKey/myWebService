package com.stone;

import com.stone.entity.Car;
import com.stone.entity.User;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

public class ClientTest {

    @Test
    public void testService() {
        // 通过WebClient对象远程调用服务端
        // 1. 创建WebClient对象
        WebClient webClient = WebClient.create("http://localhost:9001/ws/userService/user");
        User user = new User();
        user.setId(10);
        user.setUsername("stone");
        user.setCity("BeiJing");
        Car car = new Car();
        car.setId(10);
        car.setCarName("BMW");
        car.setPrice(1000000.00);
        user.getCars().add(car);
        // 2. 调用服务端方法
        webClient.post(user);
        // 设置传输的数据类型
        // webClient.type("application/xml");
    }
}
