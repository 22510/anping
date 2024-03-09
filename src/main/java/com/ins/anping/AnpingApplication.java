package com.ins.anping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.ins.anping.base.mapper")
@EnableSwagger2
@SpringBootApplication
public class AnpingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnpingApplication.class, args);
    }

}
