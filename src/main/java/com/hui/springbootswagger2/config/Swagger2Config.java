package com.hui.springbootswagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/11/26
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 配置多个组
     * @return
     */
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置docket 的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                //使用自己的方法apiInfo()
                .apiInfo(apiInfo())
                .groupName("聂广辉")
                .select()
                //表示需要扫描那个包
                //basePackage("com.hui.controller")指定扫描的包
                //any()表示扫描所有的注解
                //none()表示全部扫描
                //withClassAnnotation(RestController.class)表示扫描类上有@RestController注解的类
                //withMethodAnnotation(GetMapping.class)表示扫描方法上有@GetMapping注解的方法
                .apis(RequestHandlerSelectors.basePackage("com.hui.springbootswagger2.controller"))
                //过滤扫描表示只扫描hui/**的请求
                //.paths(PathSelectors.ant("/hui/**"))
                .build();
    }

    private ApiInfo apiInfo(){
        //作者描述
        Contact contact = new Contact("聂广辉", "http://www.nghui.cn", "2284129306@qq.com");
        return  new ApiInfo(
                "辉的文档",//文档的标题
                "座右铭:坚持总能遇见更好的自己!", //描述
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
