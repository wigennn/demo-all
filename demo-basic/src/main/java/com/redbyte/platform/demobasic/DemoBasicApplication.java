package com.redbyte.platform.demobasic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.redbyte.platform.demobasic.core.dao")
@SpringBootApplication
public class DemoBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBasicApplication.class, args);
    }

}
