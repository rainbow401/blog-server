package com.blog.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"com.blog"})
@MapperScan("com.blog.server.mapper")
public class BlogServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServerApplication.class, args);
	}

}
