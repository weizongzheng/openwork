package com.controller;
import com.pojo.User;
import com.service.LoginService;
import com.service.UserService;
import com.service.profilePicturesService;
import com.utils.DateUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class AccountController {
    @Autowired
    @Qualifier("UserService")
    UserService userService;
    @Autowired
    @Qualifier("LoginService")
    private LoginService loginService;
    @Autowired
    @Qualifier("profilePicturesService")
    profilePicturesService picturesService;
    @RequestMapping("/goAccount")
    public String goAccount(String username, Model module) {
        String password=loginService.getPassword(username);
        User user= userService.getUser(username);
        String p=picturesService.getPicture(username);
        module.addAttribute("pUrl","uploads/img/"+username+"/"+p);
        module.addAttribute("user",user);
        module.addAttribute("password",password);
        module.addAttribute("createtime", DateUtile.setDatetime(user.getCreate_time()));
        return "account";
    }
    @RequestMapping("/updatepassword")
    public void  upDatepassword(String username, String newpassword, HttpServletResponse response) throws IOException {
        loginService.updatePassword(username,newpassword);
        response.getWriter().write("ok");
    }
}
