package com.mffff.mapper;

import com.mffff.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user1 where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from user1 where username = #{username}")
    User selectByUsername(String username);

    Integer add(@Param("username") String username, @Param("password") String password);
}
