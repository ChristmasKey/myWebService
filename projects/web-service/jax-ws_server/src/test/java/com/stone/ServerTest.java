package com.stone;

import com.stone.service.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 发布服务的测试类
 */
public class ServerTest {

    public static void main(String[] args) {
        // 发布服务的工厂实例
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        // 配置服务地址
        factory.setAddress("http://localhost:12301/ws/hello");
        // 配置服务类
        factory.setServiceBean(new HelloServiceImpl());
        // 发布服务
        factory.create();

        System.out.println("发布服务成功，端口12301……");
    }
}
