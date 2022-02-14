package com.controller;
import com.alibaba.fastjson.JSON;
import com.pojo.Colum;
import com.pojo.Friend;
import com.pojo.FriendMessage;
import com.pojo.User;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class FriendController {
    @Autowired
    @Qualifier("FriendMessageService")
    FriendMessageService friendMessageService;
    @Autowired
    @Qualifier("ColumService")
    ColumService columService;
    @Autowired
    @Qualifier("FriendService")
    FriendService friendService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("profilePicturesService")
    profilePicturesService picturesService;
    @RequestMapping("/gofriend")
    public String goFriend(String username, Model model){
        List<Colum> colums=columService.getUserColum(username);
        model.addAttribute("colums",colums);
        model.addAttribute("username",username);
        return "friend";
    }
    @RequestMapping("/getlistfriend")
    public void  getlistFriend(String username,int colum,HttpServletResponse response) throws IOException {
        List<Friend> friendlist=friendService.getColumFriends(username,colum);
        String liststr=JSON.toJSONString(friendlist);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
        System.out.println(liststr);
    }
    @RequestMapping("/getfriendinf")
    public void getfriendinf(String username, String m_username, HttpSession session, HttpServletResponse response) throws IOException {
        User user=userService.getUser(username);
        System.out.println(m_username);
        String columName= columService.getColumName(username,m_username);
        Map map=new HashMap();
        map.put("user",user);
        map.put("columName",columName);
        if(picturesService.isCreatePicture(username))
        {
            String p=picturesService.getPicture(username);
            map.put("pUrl","uploads/img/"+username+"/"+p);
            session.setAttribute("pUrl","uploads/img/"+username+"/"+p);
        }
        else{
            map.put("pUrl","no");
        }
        String liststr=JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
       response.getWriter().write(liststr);
    }
    @RequestMapping("/addColum")
    public void addColum(Colum colum,HttpServletResponse response) throws IOException {
        System.out.println(colum);
        columService.addColum(colum);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleteColum")
    public void deleteColum(String username,int conlumId,HttpServletResponse response) throws IOException {
        columService.deleteColum(username,conlumId);
        System.out.println("============================"+conlumId);
        response.getWriter().write("ok");
    }
    @RequestMapping("/updateColum")
    public void updateColum(String username,int columId,String uName,int uPor,HttpServletResponse response) throws IOException {
        Colum c=columService.findColum(username,columId);
        if(!uName.equals("；sldkssdlkskd；"))
            c.setColum_name(uName);
        if(uPor!=0)
            c.setPro(uPor);
        columService.updateColum(c);
        response.getWriter().write("ok");
    }
    @RequestMapping("/isFriend")
    public void isFriend(String username,String m_username,HttpServletResponse response) throws IOException {
        int flag= friendService.isFriend(m_username,username);
        if(flag==0)
        response.getWriter().write("no");
        else
            response.getWriter().write("ok");
    }
    @RequestMapping("/searchFriendinf")
    public void searchFriendinf(String username,String m_username,HttpServletResponse response) throws IOException {
        User user=userService.getUser(username);
        String columName= columService.getColumName(username,m_username);
        Friend friend=friendService.getfriendinf(m_username,username);
        Map map=new HashMap();
        map.put("user",user);
        map.put("columName",columName);
        map.put("create",friend.getCreate_time());
        String liststr=JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/haveuser")
    public void haveuser(String username,HttpServletResponse response) throws IOException {
        int flag= userService.isexsist(username);
        if(flag==0)
            response.getWriter().write("no");
        else
            response.getWriter().write("ok");
    }
    @RequestMapping("/putFriendMessage")
    public void addFriend(String username,String m_username,String addmessage,int columId,String addnickname,HttpServletResponse response) throws IOException {
        FriendMessage friendMessage=new FriendMessage(m_username,username,new Date(),0
                ,addmessage,columId,0,addnickname,null,-1,null);
        friendMessageService.createFriendMessage(friendMessage);
        response.getWriter().write("ok");
    }
    @RequestMapping("/updateUserColum")
    public void updateUserColum(String username,String m_username,int columId,HttpServletResponse response) throws IOException {
       friendService.updateUserColum(m_username,username,columId);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deletefriend")
    public void deletefriend(String username,String m_username,HttpServletResponse response) throws IOException {
        friendService.deleteFriend(m_username,username);
        response.getWriter().write("ok");
    }
    @RequestMapping("/sendToUser")
    public void sendToUser(String username,String m_username,String text,HttpServletResponse response) throws IOException {
        System.out.println(username);
        FriendMessage friendMessage=new FriendMessage(m_username,username,new Date(),
                0,text,0,0,null,null,2,new Date());
        friendMessageService.createFriendMessage(friendMessage);
        response.getWriter().write("ok");
    }
}
