package com.ins.anping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ins.anping.base.mapper")
@SpringBootApplication
public class AnpingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnpingApplication.class, args);
    }

}
