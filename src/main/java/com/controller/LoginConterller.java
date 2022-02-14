package com.controller;
import com.pojo.Colum;
import com.pojo.User;
import com.service.ColumService;
import com.service.LoginService;
import com.service.UserService;
import com.utils.DateUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
@Controller
@RequestMapping("/login")
public class LoginConterller {
    @Autowired
    @Qualifier("LoginService")
    private LoginService loginService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("ColumService")
    ColumService columService;
    @RequestMapping("/into")
    public String register(){//进入注册页面
        return "register";
    }
    @RequestMapping("/ok")
    public String okRegister(User user, String password) {
        user.setCreate_time(new Date());
        System.out.println(user);
        userService.createUser(user);
        loginService.createLogin(user.getUsername(),password);
        Colum colum=new Colum(1,user.getUsername(),"default",0,0);
        columService.addColum(colum);
        return "register";
    }
    @RequestMapping("/isregister")
    public void isRegister(String username, HttpServletResponse response) throws IOException {
        String msg="";
        int isR=loginService.is_create(username);
        if(isR==1)
        {
            msg="done";
        }
        response.getWriter().write(msg);
    }
    @PostMapping("/validation")
    public void validation(String username, String password, HttpServletResponse response) throws IOException {

        System.out.println(username);
        String msg="";
        if(loginService.is_create(username)==0)
            msg="N";
        else{
            String corpassword=loginService.getPassword(username);
            if(corpassword.equals(password)) {
                msg = "Y";
            }
            else
                msg="N";

        }
        System.out.println("===========================");
        response.getWriter().write(msg);
    }

}
