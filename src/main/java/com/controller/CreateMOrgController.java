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
public class CreateMOrgController {
    @Autowired
    @Qualifier("FriendService")
    FriendService friendService;
    @Autowired
    @Qualifier("OrgService")
    OrgService orgService;
    @Autowired
    @Qualifier("OrgMessageService")
    OrgMessageService orgMessageService;
    @Autowired
    @Qualifier("UserService")
    private UserService userService;
    @Autowired
    @Qualifier("IntoOrgService")
    private IntoOrgService intoOrgService;
    @RequestMapping("/goOrgManage")
    public String goOrgManage(String username, Model model){
        List<Friend> friends=friendService.getAllFriends(username);
        List<User> users=new ArrayList<>();
        for(Friend friend:friends)
        {
            users.add(userService.getUser(friend.getUsername()));
        }
        System.out.println(friends);
        model.addAttribute("username",username);
        model.addAttribute("users",users);
        model.addAttribute("friends",friends);
        return "CreateManageOrg";
    }
    @RequestMapping("/createOrg")
    public void createOrg(String org_id, String org_name, String content, String list, HttpServletResponse response) throws IOException {
        List<String> list1=(List<String>)JSON.parse(list);
        Org org=new Org(org_id,list1.get(0),new Date(),org_name,content,list1.size());
        for(int i=1;i<list1.size();i++)
        {
            OrgMessage message=new OrgMessage(org_id,list1.get(i),new Date(),0,
                    "您加入"+list1.get(0)+"创建的组织:"+org_name);
            orgMessageService.createOrgMessage(message);
        }
        intoOrgService.ListintoOrg(org_id,list1);
        orgService.createOrg(org);
        response.getWriter().write("y");
    }
    @RequestMapping("/getUserAllOrg")
    public void getUserAllOrg(String username, HttpServletResponse response) throws IOException {
        List<Org> orgs=orgService.getUserAllOrg(username);
        String liststr=JSON.toJSONString(orgs);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/showOrgInf")
    public void showOrgInf(String org_id, HttpServletResponse response) throws IOException {
        Org org=orgService.getOrg(org_id);
        List<IntoOrg> intoOrgs=intoOrgService.getInto_User_List(org_id);
        List<User> users=new ArrayList<>();
        for(IntoOrg intoOrg:intoOrgs)
        {
            users.add(userService.getUser(intoOrg.getUsername()));
        }
        Map map=new HashMap();
        map.put("org",org);
        map.put("users",users);
        String liststr=JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/upContent")
    public void upContent(String org_id, String content,HttpServletResponse response) throws IOException {
        orgService.updateContent(org_id,content);
        String liststr=JSON.toJSONString("ok");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/upOrgName")
    public void upOrgName(String org_id, String name,HttpServletResponse response) throws IOException {
        orgService.updateName(org_id,name);
        String liststr=JSON.toJSONString("ok");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/addUser")
    public void addUser(String org_id, String addusername,HttpServletResponse response) throws IOException {
        int is=userService.isexsist(addusername);
        if(is==0)
        {
            response.getWriter().write("no");
        }
        else{
            if(intoOrgService.isIntoOrg(org_id,addusername))
            {
                response.getWriter().write("no1");
            }
            else{
                intoOrgService.intoOrg(org_id,addusername);
                response.getWriter().write("yes");
            }
        }
    }
    @RequestMapping("/deteUser")
    public void MandatorydeteUser(String org_id, String deleusername,HttpServletResponse response) throws IOException {
        intoOrgService.mandatoryDeleteUser(org_id,deleusername);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleOrg")
    public void deleOrg(String org_id,HttpServletResponse response) throws IOException {
        intoOrgService.deleteOrg(org_id);
        orgService.deleteOrg(org_id);
        orgMessageService.deleteOrgAllMessage(org_id);
        response.getWriter().write("ok");
    }
    @RequestMapping("/Org_exsits")
    public void Org_exsits(String org_id,HttpServletResponse response) throws IOException {
        if(orgService.orgIsExit(org_id))
            response.getWriter().write("ok");
        else
            response.getWriter().write("no");
    }
}
