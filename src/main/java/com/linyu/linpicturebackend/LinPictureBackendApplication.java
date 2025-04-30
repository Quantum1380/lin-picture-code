package com.linyu.linpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.linyu.linpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class LinPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinPictureBackendApplication.class, args);
    }
}