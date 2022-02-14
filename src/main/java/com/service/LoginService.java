package com.service;
import com.dao.LoginDao;
import org.springframework.stereotype.Service;
@Service
public class LoginService implements LoginInter {
    LoginDao logindao;
    public LoginDao getLogindao() {
        return logindao;
    }
    public void setLogindao(LoginDao logindao) {
        this.logindao = logindao;
    }
    public int createLogin(String username, String password) {
        return logindao.createLogin(username,password);
    }
    public int is_create(String username) {
        return logindao.is_create(username);
    }
    @Override
    public String getPassword(String username) {
        return logindao.getPassword(username);
    }
    @Override
    public int updatePassword(String username, String password) {
        return logindao.updatePassword(username,password);
    }
}
