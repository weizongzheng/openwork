package com.controller;
import com.alibaba.fastjson.JSON;
import com.pojo.*;
import com.service.CourseService;
import com.service.IntoClassService;
import com.service.OrgService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@Controller
public class CourseController {
    @Autowired
    @Qualifier("IntoClassService")
    IntoClassService intoClassService;
    @Autowired
    @Qualifier("CourseService")
    CourseService courseService;
    @Autowired
    @Qualifier("UserService")
    UserService userService;
    @RequestMapping("/goCourse")
    public String goCourse(String username, Model model){
        int number=intoClassService.intoClassNumber(username);
        List<Course> courses=new ArrayList<>();
        if(number!=0) {
            List<IntoClass> courseList= intoClassService.getCourseList(username,0,10);
            for (IntoClass intoClass : courseList) {
                Course course=courseService.getCourse(intoClass.getCourse_id());
                courses.add(course);
            }
        }
        model.addAttribute("username",username);
        model.addAttribute("courses",courses);
        model.addAttribute("number",number);
        return "Course";
    }
    @RequestMapping("/golimitcourse")
    public void golimitorg(String username, int begin, int end, HttpServletResponse response, Model model) throws IOException {
        int number=intoClassService.intoClassNumber(username);
        List<Course> courses=new ArrayList<>();
        if(number>begin) {
            List<IntoClass> courseList= intoClassService.getCourseList(username,begin,end);
            for (IntoClass intoClass : courseList) {
                Course course=courseService.getCourse(intoClass.getCourse_id());
                courses.add(course);
            }
        }
        model.addAttribute("courses",courses);
        String liststr= JSON.toJSONString(courses);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getcourseinformation")
    public void getCourseinformation(String courseid, HttpServletResponse response) throws IOException {
        Course course=courseService.getCourse(courseid);
        List<IntoClass> courseList=intoClassService.getInto_User_List(courseid);
        List<User> users=new ArrayList<>();
        for(IntoClass intoClass :courseList)
        {
            users.add(userService.getUser(intoClass.getUsername()));
        }
        Map map=new HashMap();
        map.put("course",course);
        map.put("users",users);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/isInCourse")
    public void isInOrg(String courseid,String username,HttpServletResponse response) throws IOException {
        if(intoClassService.isIntoCourse(courseid,username))
        {
            response.getWriter().write("y");
        }
        else{
            response.getWriter().write("n");
        }
    }
    @RequestMapping("/exitcourse")
    public void exitcourse(String courseid,String username,HttpServletResponse response) throws IOException {
        intoClassService.exitCourse(courseid,username);
        courseService.exitCourse(courseid);
        response.getWriter().write("yes");
    }
    @RequestMapping("/addcourse")
    public void addcourse(String course_id,String username,HttpServletResponse response) throws IOException {
        if(!courseService.CourseIsExists(course_id)){
            response.getWriter().write("no");
        }
        else{
            if(intoClassService.be_deleted(course_id,username))
                response.getWriter().write("no1");
            else {
                intoClassService.intoClass(new IntoClass(course_id, username, 0, 0, 0));
                response.getWriter().write("yes");
            }
        }
    }
}
