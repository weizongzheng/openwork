package com.dao;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;
public interface UserDao {
    int createUser(User username);
    String getUsername(@Param("username") String username);
    User getUser(@Param("username") String username);
    int updateUser(User user);
    int isexsist(@Param("username") String username);
}
