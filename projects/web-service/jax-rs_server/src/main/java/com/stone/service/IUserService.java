package com.stone.service;

import com.stone.entity.User;

import javax.ws.rs.*;
import java.util.List;

@Path("/userService") // 访问当前服务接口对应的路径
@Produces("*/*") // 服务器支持的返回的数据格式类型，*/*表示任意类型
public interface IUserService {

    @POST // 表示处理的请求的类型
    @Path("/user") // 访问当前服务接口中的方法对应的路径，拼接后即 .../userService/user
    @Consumes({"application/json", "text/xml"}) // 服务器支持的请求的数据格式类型
    void saveUser(User user);

    @PUT
    @Path("/user")
    @Consumes({"application/json", "application/xml"})
    void updateUser(User user);

    @GET
    @Path("/user")
    @Produces({"application/json", "application/xml"})
    List<User> queryUser();

    @GET
    @Path("/user/{id}")
    @Consumes({"application/xml"})
    @Produces({"application/json", "application/xml"})
    User findUserById(@PathParam("id") Integer id);

    @DELETE
    @Path("/user/{id}")
    @Consumes({"application/json", "application/xml"})
    void deleteUser(@PathParam("id") Integer id);
}
