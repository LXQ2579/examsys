package com.damo.examsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableCaching
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.damo.examsys.dao") //扫描dao层, 与数据类型绑定相关
public class ExamsysApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExamsysApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamsysApplication.class, args);
    }

}
