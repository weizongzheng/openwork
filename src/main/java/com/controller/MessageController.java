package com.controller;
import com.alibaba.fastjson.JSON;
import com.pojo.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@Controller
public class MessageController {
    @Autowired
    @Qualifier("CourseMessageService")
    CourseMessageService courseMessageService;
    @Autowired
    @Qualifier("FriendMessageService")
    FriendMessageService friendMessageService;
    @Autowired
    @Qualifier("OrgMessageService")
    OrgMessageService orgMessageService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("CourseService")
    private CourseService courseService;
    @Autowired
    @Qualifier("OrgService")
    private OrgService orgService;
    @Autowired
    @Qualifier("ColumService")
    private ColumService columService;
    @Autowired
    @Qualifier("FriendService")
    private FriendService friendService;
    @RequestMapping("/gomessage")
    public String goMessage(String username, Model model){
        int readed=1;
        int friendread=friendMessageService.countNumber(username,readed);
        int courseread=courseMessageService.countNumber(username,readed);
        int orgread=orgMessageService.countNumber(username,readed);
        readed=0;
        int sumNread=orgMessageService.countNumber(username,readed)+
                courseMessageService.countNumber(username,readed)+
                friendMessageService.countNumber(username,readed);
        model.addAttribute("friendNread",friendread);
        model.addAttribute("courseNread",courseread);
        model.addAttribute("orgNread",orgread);
        model.addAttribute("sumNread",sumNread);
        model.addAttribute("username",username);
        return "message";
    }
    @RequestMapping("/getReadedMessage")
    public void getReadedMessage(String username,int readed, HttpServletResponse response) throws IOException {
        int friendread=friendMessageService.countNumber(username,readed);
        int courseread=courseMessageService.countNumber(username,readed);
        int orgread=orgMessageService.countNumber(username,readed);
        Map map=new HashMap();
        map.put("friendread",friendread);
        map.put("courseread",courseread);
        map.put("orgread",orgread);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getfriendMelist")
    public void getfriendMelist(String username,int readed, HttpServletResponse response) throws IOException {
        List<FriendMessage> friendMessageList =friendMessageService.getFriendMeList(username,readed);
        List<String> name=new ArrayList<String>();
        for(FriendMessage friendMessage:friendMessageList)
        {
            name.add(userService.getUsername(friendMessage.getM_username()));
        }
        Map map=new HashMap();
        map.put("friendMessageList",friendMessageList);
        map.put("name",name);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getcourseMelist")
    public void getcourseMelist(String username,int readed, HttpServletResponse response) throws IOException {
        List<CourseMessage> courseMessageList =courseMessageService.getCourseMeList(username,readed);
        List<String> name=new ArrayList<String>();
        List<String> uname=new ArrayList<String>();
        List<String> urealname=new ArrayList<String>();
        for(CourseMessage courseMessage:courseMessageList)
        {
            name.add(courseService.gettitle(courseMessage.getCourse_id()));
        }
        for(CourseMessage courseMessage:courseMessageList)
        {
            String temp=courseService.getCreateUsername(courseMessage.getCourse_id());
            uname.add(temp);
            urealname.add(userService.getUsername(temp));
        }
        Map map=new HashMap();
        map.put("courseMessageList",courseMessageList);
        map.put("name",name);
        map.put("uname",uname);
        map.put("urealname",urealname);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getorgMelist")
    public void getorgMelist(String username,int readed, HttpServletResponse response) throws IOException {
        List<OrgMessage> OrgMessageList =orgMessageService.getOrgMeList(username,readed);
        List<String> name=new ArrayList<String>();
        List<String> uname=new ArrayList<String>();
        List<String> urealname=new ArrayList<String>();
        for(OrgMessage orgMessage:OrgMessageList)
        {
            String id=orgMessage.getOrg_id();
            name.add(orgService.getOrgName(id));
            String temp=orgService.getCreateOrgUsername(id);
            uname.add(temp);
            urealname.add(userService.getUsername(temp));
        }
        Map map=new HashMap();
        map.put("OrgMessageList",OrgMessageList);
        map.put("name",name);
        map.put("uname",uname);
        map.put("urealname",urealname);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getFriendRequestInformation")
    public void getFriendRequestInformation(String username,String m_username,Date create,int readed,HttpServletResponse response) throws IOException {
       FriendMessage friendMessage= friendMessageService.getFriendMessage(username,m_username,create,readed);
        List<Colum> colums=columService.getUserColum(username);
       Map map=new HashMap();
       map.put("friendMessage",friendMessage);
       map.put("name",userService.getUsername(m_username));
       map.put("colums",colums);
       String liststr= JSON.toJSONString(map);
       response.setCharacterEncoding("utf-8");
       response.getWriter().write(liststr);
    }
    @RequestMapping("/addfriend")
    public void addfriend(FriendMessage friendMessage,HttpServletResponse response) throws IOException {
        System.out.println("=============================");
        System.out.println(friendMessage);
        friendMessage.setSub_time(new Date());
        friendService.addFriends(friendMessage);
        FriendMessage backFriendMessage=new FriendMessage(null,
                friendMessage.getM_username(),new Date(),0,friendMessage.getUsername()+"接受您的好友请求",
               0,0,null,null,1,null );
        friendMessageService.createFriendMessage(backFriendMessage);
        friendMessageService.okToFriend(friendMessage);
        friendMessageService.submit_it(friendMessage);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("ok");
    }
    @RequestMapping("/refusefriend")
    public void refusefriend(FriendMessage friendMessage,HttpServletResponse response) throws IOException {
        System.out.println("=============================");
        System.out.println(friendMessage);
        friendMessage.setSub_time(new Date());
        friendMessageService.noToFriend(friendMessage);
        friendMessageService.submit_it(friendMessage);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("ok");
    }
    @RequestMapping("/alertRead")
    public void alertRead(String username,String m_username,Date create_time,String message,HttpServletResponse response) throws IOException {
        if(message.equals("friend"))
            friendMessageService.readIt(username,create_time,m_username);
        else if(message.equals("course"))
            courseMessageService.readIt(username,create_time,m_username);
        else if(message.equals("org"))
            orgMessageService.readIt(username,create_time,m_username);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("ok");
    }
    @RequestMapping("/getOrgInformation")
    public void getOrgInformation(String org_id,String username,Date create,int readed,HttpServletResponse response) throws IOException {
        Org org=orgService.getOrg(org_id);
        OrgMessage orgMessage=orgMessageService.getOrgMessage(username,org_id,readed,create);
        Map map =new HashMap();
        map.put("org",org);
        map.put("orgMessage",orgMessage);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/Read_Org")
    public void Read_Org(String org_id,String username,Date create_time,HttpServletResponse response) throws IOException {
        orgMessageService.readIt(username,create_time,org_id);
        response.getWriter().write("ok");
    }
    @RequestMapping("/getCourseInformation")
    public void getCourseInformation(String course_id,String username,Date create,Integer readed,HttpServletResponse response) throws IOException {
        Course course=courseService.getCourse(course_id);
        CourseMessage courseMessage=courseMessageService.getCourseMessage(course_id,username,create,readed);
        Map map =new HashMap();
        map.put("course",course);
        map.put("courseMessage",courseMessage);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/Read_Course")
    public void Read_Course(String course_id,String username,Date create_time,HttpServletResponse response) throws IOException {
        courseMessageService.readCourseMessage(username,create_time,course_id);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleteFriendMessage")
    public void deleteFriendMessage(String username,String m_username,Date createtime,HttpServletResponse response) throws IOException {
        friendMessageService.deleteFriendMessage(username,createtime,m_username);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleteOrgMessage")
    public void deleteOrgMessage(String username,String org_id,Date createtime,HttpServletResponse response) throws IOException {
        orgMessageService.deleteOrgMessage(username,createtime,org_id);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleteCourseMessage")
    public void deleteCourseMessage(String username,String course_id,Date createtime,HttpServletResponse response) throws IOException {
        courseMessageService.deleteCourseMessage(username,createtime,course_id);
        response.getWriter().write("ok");
    }
}
