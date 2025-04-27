package com.stone.service;

import javax.jws.WebService;

/**
 * 对外发布服务的接口
 */
@WebService
public interface HelloService {

    /**
     * 对外发布服务的接口的方法
     */
    String sayHello(String name);
}
