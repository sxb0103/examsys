package com.fqedu.examsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fqedu.examsys.dao")
public class ExamsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamsysApplication.class, args);
    }

}
