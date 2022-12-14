package com.mffff.mffffyupiusercenter;

import com.mffff.mffffyupiusercenter.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.mffff.mffffyupiusercenter.mapper.UserMapper"})
public class MffffYupiUserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MffffYupiUserCenterApplication.class, args);
	}

}
