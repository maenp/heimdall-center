package com.heimdall.center.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.heimdall")
@MapperScan(basePackages = {"com.heimdall.center.console.dao"})
public class HeimdallCenterConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeimdallCenterConsoleApplication.class, args);
	}

}
