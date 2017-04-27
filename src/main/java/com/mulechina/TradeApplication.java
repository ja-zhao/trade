package com.mulechina;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.mulechina.mapper")
public class TradeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TradeApplication.class, args);
	}
}
