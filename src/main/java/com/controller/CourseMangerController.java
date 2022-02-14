package com.controller;
import com.alibaba.fastjson.JSON;
import com.pojo.*;
import com.service.*;
import com.utils.OrgListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@Controller
public class CourseMangerController {
    @Autowired
    @Qualifier("FriendService")
    FriendService friendService;
    @Autowired
    @Qualifier("CourseService")
    CourseService CourseService;
    @Autowired
    @Qualifier("OrgService")
    OrgService orgService;
    @Autowired
    @Qualifier("IntoOrgService")
    IntoOrgService intoOrgService;
    @Autowired
    @Qualifier("IntoClassService")
    IntoClassService intoClassService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("CourseService")
    private CourseService courseService;
    @Autowired
    @Qualifier("CourseWorkService")
    private CourseWorkService courseWorkService;
    @Autowired
    @Qualifier("CourseMessageService")
    private CourseMessageService courseMessageService;
    @Autowired
    @Qualifier("IntoWorkService")
    private IntoWorkService intoWorkService;
    @RequestMapping("/goCourseManger")
    public String goCourseManger(String username, Model model){
        List<Friend> friends=friendService.getAllFriends(username);
        List<User> users=new ArrayList<>();
        for(Friend friend:friends)
        {
            users.add(userService.getUser(friend.getUsername()));
        }
        List<IntoOrg> intoOrgs=intoOrgService.getUserAllOrg(username);
        List<Org> orgs=new ArrayList<>();
        for(IntoOrg intoOrg:intoOrgs)
        {
            orgs.add(orgService.getOrg(intoOrg.getOrg_id()));
        }
        model.addAttribute("username",username);
        model.addAttribute("users",users);
        model.addAttribute("friends",friends);
        model.addAttribute("orgs",orgs);
        return "CourseManger";
    }
    @RequestMapping("/createCourse")
    public void createOrg(String course_id, String course_name, String content, String list,String orglist, HttpServletResponse response) throws IOException {
        List<String> listfriend=(List<String>) JSON.parse(list);
        List<String> listorg=(List<String>) JSON.parse(orglist);
        int org_user_number=0;
        for(String o:listorg)
        {
            org_user_number+=intoOrgService.getOrg_UserNumber(o);
        }
        Set<String> set=new HashSet<>();
        List<String> orgListAllUser = OrgListUtil.getOrgListAllUser(listorg, intoOrgService);
        for(String friend:listfriend)
        {
            set.add(friend);
        }
        for(String user:orgListAllUser)
        {
            set.add(user);
        }
        Course course =new Course(course_id,new Date(),listfriend.get(0),course_name,set.size(),0,content);
        intoClassService.intoFriendClass(set,course_id);
        CourseService.createCourse(course);
        for(String s:set)
        {
            CourseMessage courseMessage=new CourseMessage(course_id,s,new Date(),0,
                    "您加入"+listfriend.get(0)+"创建的课程:"+course_name);
            courseMessageService.createCourseMessage(courseMessage);
        }
        response.getWriter().write("y");
    }
    @RequestMapping("/Course_exsits")
    public void Org_exsits(String course_id,HttpServletResponse response) throws IOException {
        if(!courseService.CourseIsExists(course_id))
            response.getWriter().write("no");
        else
            response.getWriter().write("ok");
    }
    @RequestMapping("/getUserAllCourse")
    public void getUserAllCourse(String username, HttpServletResponse response) throws IOException {
        List<Course> userAllCourse = courseService.getUserAllCourse(username);
        String liststr=JSON.toJSONString(userAllCourse);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/showCourseInf")
    public void showOrgInf(String course_id, HttpServletResponse response) throws IOException {
        Course course=courseService.getCourse(course_id);
        List<IntoClass> into_user_list = intoClassService.getInto_User_List(course_id);
        List<User> users=new ArrayList<>();
        for(IntoClass intoClass:into_user_list)
        {
            users.add(userService.getUser(intoClass.getUsername()));
        }
        Map map=new HashMap();
        map.put("course",course);
        map.put("users",users);
        String liststr=JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/upCourseName")
    public void upOrgName(String course_id, String name,HttpServletResponse response) throws IOException {
        courseService.updateName(course_id,name);
        String liststr=JSON.toJSONString("ok");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/upCourseContent")
    public void upCourseContent(String course_id, String courseContent,HttpServletResponse response) throws IOException {
        courseService.updateContent(course_id,courseContent);
        String liststr=JSON.toJSONString("ok");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/addUsertoCourse")
    public void addUsertoCourse(String course_id, String addusername,HttpServletResponse response) throws IOException {
        int is=userService.isexsist(addusername);
        if(is==0)
        {
            response.getWriter().write("no");
        }
        else{
            if(intoClassService.isIntoCourse(course_id,addusername))
            {
                response.getWriter().write("no1");
            }
            else{
                Set<String> strings=new HashSet<>();
                strings.add(addusername);
                intoClassService.intoFriendClass(strings,course_id);
                response.getWriter().write("yes");
            }
        }
    }
    @RequestMapping("/deleUserFromCourse")
    public void deleUserFromCourse(String course_id, String deleusername,HttpServletResponse response) throws IOException {
        intoClassService.mandatoryDeleteUser(course_id,deleusername);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleCourse")
    public void deleCourse(String course_id,HttpServletResponse response) throws IOException {
        intoClassService.deleteCourse(course_id);
        courseService.deleteCourse(course_id);
        courseWorkService.deleteCourseAllWork(course_id);
        intoWorkService.deleteCourse_ALLWork(course_id);
        courseMessageService.deleteCourseAllMessage(course_id);
        response.getWriter().write("ok");
    }
}
