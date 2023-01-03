package com.mffff.usercenter.service;
import java.util.Date;

import com.mffff.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        System.out.println(userService);
        User user = new User();
        user.setUsername("mftest1");
        user.setUserAccount("mffff");
        user.setAvatarUrl("url");
        user.setGender(0);
        user.setUserPassword("mffff");
        user.setPhone("18031835710");
        user.setEmail("18031835710@163.com");
        user.setPlanetCode("mffff");
        boolean result = userService.save(user);
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAcouunt = "zhangmengfei1";
        String userPassword = "zhangmengfei1";
        String checkPassword = "zhangmengfei1";
        long result = userService.userRegister(userAcouunt, userPassword, checkPassword);
        Assertions.assertNotEquals(-1, result);
    }
}