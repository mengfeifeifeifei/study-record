package com.mffff.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mffff.usercenter.model.domain.User;

import javax.servlet.http.HttpServletRequest;

/**
* @author zhuyuxiang
* @description 针对表【user】的数据库操作Service
* @createDate 2022-12-30 14:31:04
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount 账户
     * @param userPassword 密码
     * @param checkPassword 校验密码
     * @return 新用户Id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @param userAccount 账户
     * @param userPassword 密码
     * @param request 请求
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 原用户信息
     * @return 脱敏后用户信息
     */
    User getSafetyUser(User originUser);
}
