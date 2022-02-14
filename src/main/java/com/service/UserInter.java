package com.service;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;
public interface UserInter {
    int createUser(User user);
    String getUsername( String username);
    User getUser( String username);
    int updateUser(User user);
    int isexsist(String username);
}
