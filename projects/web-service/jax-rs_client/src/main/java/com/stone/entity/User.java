package com.stone.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于Restful风格的WebService，客户端与服务端之间通讯既可以传递XML数据，也可以传递JSON数据
 * '@XmlRootElement注解' 指定对象序列化为XML或JSON数据时根节点的名称
 * xml数据格式：
 * <user>
 *     <id>1</id>
 *     <username>stone</username>
 *     <city>北京</city>
 *     <cars>
 *         <car>
 *             <name>奔驰</name>
 *             ...
 *         </car>
 *         ...
 *     </cars>
 * </user>
 * json数据格式：
 * {
 *     "User": {
 *        "id": 1,
 *        "username": "stone",
 *        "city": "北京",
 *        "cars": [
 *            {
 *                "name": "奔驰",
 *                ...
*             }
*             ...
*         ]
 *    }
 * }
 */
@XmlRootElement(name = "User")
public class User {

    private Integer id;
    private String username;
    private String city;

    private List<Car> cars = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", city='" + city + '\'' +
                ", cars=" + cars +
                '}';
    }
}
