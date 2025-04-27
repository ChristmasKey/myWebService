package com.stone;

import com.stone.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 调用服务的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ClientTest {

    // 注入对象
    @Resource
    private HelloService helloService;

    @Test
    public void remote() {
        // 查看接口的代理对象类型
        System.out.println(helloService.getClass());

        // 远程访问服务端方法
        System.out.println(helloService.sayHello("stone"));
    }
}
