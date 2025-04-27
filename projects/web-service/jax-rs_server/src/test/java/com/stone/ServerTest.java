package com.stone;

import com.stone.service.impl.UserServiceImpl;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class ServerTest {

    public static void main(String[] args) {
        // 创建发布服务的工厂
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        // 配置服务地址
        factory.setAddress("http://localhost:9001/ws/");
        // 配置服务类
        factory.setServiceBean(new UserServiceImpl());
        // 添加日志输入输出拦截器
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        // 发布服务
        factory.create();
        System.out.println("发布服务成功，端口9001");
    }
}
