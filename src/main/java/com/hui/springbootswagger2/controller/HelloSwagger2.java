package com.hui.springbootswagger2.controller;

import com.hui.springbootswagger2.bean.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/11/26
 */
@RestController
public class HelloSwagger2 {

    @GetMapping("/hello")
    public String helloSwagger2(){
        return "helloSwagger2";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setPassword("123456");
        user.setUsername("张三");
        return user;
    }

    @ApiOperation("测试用户信息")
    @PostMapping("/user/test")
    public User test(@ApiParam("用户名") String username,@ApiParam("密码") String password){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        System.out.println(user);
        return user;
    }

}
