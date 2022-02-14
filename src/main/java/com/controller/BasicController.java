package com.controller;
import com.pojo.User;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class BasicController {
    @Autowired
    @Qualifier("LoginService")
    private LoginService loginService;
    @Autowired
    @Qualifier("FriendService")
    private FriendService friendService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("IntoClassService")
    private IntoClassService intoClassService;
    @Autowired
    @Qualifier("CourseService")
    private CourseService courseService;
    @RequestMapping ("/login/gomain")
    public String gomain(String username, Model model){
        String name=userService.getUsername(username);
        System.out.println(name);
        model.addAttribute("name",name);
        model.addAttribute("username",username);
        return "main";
    }
    @RequestMapping("/getbasic")
    public String getbasic(String username ,Model model){
        int friendnumber=friendService.friendNumber(username);
        int intoclassnumber=intoClassService.intoClassNumber(username);
        int createcoursenumber=courseService.createCourseNumber(username);
        model.addAttribute("friendnumber",friendnumber);
        model.addAttribute("intoclassnumber",intoclassnumber);
        model.addAttribute("createcoursenumber",createcoursenumber);
        return "basic";
    }
    @RequestMapping("/modify")
    public void update(User user, HttpServletResponse response) throws IOException {
        userService.updateUser(user);
        response.getWriter().write("ok");
    }
}
