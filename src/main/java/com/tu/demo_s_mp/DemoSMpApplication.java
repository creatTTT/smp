package com.tu.demo_s_mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tu.demo_s_mp.mapper")
public class DemoSMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSMpApplication.class, args);
	}

}
