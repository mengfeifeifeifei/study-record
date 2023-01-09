package com.mffff.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mffff.usercenter.mapper"})
public class MffffUserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MffffUserCenterApplication.class, args);
	}

}
