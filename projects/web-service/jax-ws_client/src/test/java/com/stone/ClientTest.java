package com.stone;

import com.stone.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 调用服务的测试类
 */
public class ClientTest {

    public static void main(String[] args) {
        // 创建cxf代理工厂
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        // 配置服务接口访问地址：http://localhost:12301/ws/hello
        factory.setAddress("http://localhost:12301/ws/hello");
        // 配置接口类型（服务的接口规范）
        factory.setServiceClass(HelloService.class);
        // 对接口生成代理对象
        HelloService helloService = factory.create(HelloService.class);
        // 可以查看下代理对象
        // Java中的代理分为：
        // 1.静态代理
        // 2.动态代理（jdk接口代理 $Proxy***、cglib子类代理 $CGLIB***）
        System.out.println(helloService.getClass());
        // 远程调用服务端方法
        String result = helloService.sayHello("Stone");
        System.out.println("调用服务接口：" + result);
    }
}
