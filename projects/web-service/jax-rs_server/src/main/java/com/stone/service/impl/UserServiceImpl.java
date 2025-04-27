package com.stone.service.impl;

import com.stone.entity.Car;
import com.stone.entity.User;
import com.stone.service.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Override
    public void saveUser(User user) {
        System.out.println("save user: " + user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("update user: " + user);
    }

    @Override
    public List<User> queryUser() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("张三");
        user1.setCity("北京");
        List<Car> user1Cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1);
        car1.setCarName("奔驰");
        car1.setPrice(1000000.00);
        user1Cars.add(car1);
        Car car2 = new Car();
        car2.setId(2);
        car2.setCarName("宝马");
        car2.setPrice(2000000.00);
        user1Cars.add(car2);
        user1.setCars(user1Cars);
        users.add(user1);
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("李四");
        user2.setCity("上海");
        List<Car> user2Cars = new ArrayList<>();
        Car car3 = new Car();
        car3.setId(3);
        car3.setCarName("奥迪");
        car3.setPrice(3000000.00);
        user2Cars.add(car3);
        Car car4 = new Car();
        car4.setId(4);
        car4.setCarName("大众");
        car4.setPrice(4000000.00);
        user2Cars.add(car4);
        user2.setCars(user2Cars);
        users.add(user2);
        return users;
    }

    @Override
    public User findUserById(Integer id) {
        if (id == 1) {
            User user1 = new User();
            user1.setId(1);
            user1.setUsername("张三");
            user1.setCity("北京");
            List<Car> user1Cars = new ArrayList<>();
            Car car1 = new Car();
            car1.setId(1);
            car1.setCarName("奔驰");
            car1.setPrice(1000000.00);
            user1Cars.add(car1);
            Car car2 = new Car();
            car2.setId(2);
            car2.setCarName("宝马");
            car2.setPrice(2000000.00);
            user1Cars.add(car2);
            user1.setCars(user1Cars);
            return user1;
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        System.out.println("delete user: " + id);
    }
}
