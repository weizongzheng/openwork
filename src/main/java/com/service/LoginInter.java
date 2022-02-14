package com.service;
import org.apache.ibatis.annotations.Param;
public interface LoginInter {
    int createLogin(String username, String password);
    int is_create(String username);
    String getPassword(String username);
    int updatePassword( String username, String password);
}
