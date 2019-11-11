package com.shinham;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.shinham.mapper")
@EnableAutoConfiguration
public class ChartDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartDemoApplication.class, args);
	}

}
