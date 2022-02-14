package com.service;
import com.dao.UserDao;
import com.pojo.User;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserInter{
    UserDao userDao;
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public int createUser(User user) {
        return userDao.createUser(user);
    }
    @Override
    public String getUsername(String username) {
        return userDao.getUsername(username);
    }
    @Override
    public User getUser(String username) {
        return userDao.getUser(username);
    }
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
    @Override
    public int isexsist(String username) {
        return userDao.isexsist(username);
    }
}
