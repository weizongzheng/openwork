package com.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
public interface LoginDao {
    int createLogin(@Param("name") String username, @Param("pwd") String password);
    int is_create(@Param("name") String username);
    String getPassword(@Param("name") String username);
    int updatePassword(@Param("username") String username,@Param("newpass") String password);
}
