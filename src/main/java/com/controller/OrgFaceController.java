package com.controller;
import com.alibaba.fastjson.JSON;
import com.pojo.IntoOrg;
import com.pojo.Org;
import com.pojo.User;
import com.service.IntoOrgService;
import com.service.OrgService;
import com.service.UserService;
import com.utils.DateUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
@Controller
public class OrgFaceController {
    @Autowired
    @Qualifier("IntoOrgService")
    IntoOrgService intoOrgService;
    @Autowired
    @Qualifier("OrgService")
    OrgService orgService;
    @Autowired
    @Qualifier("UserService")
    UserService userService;
    @RequestMapping("/goorgFace")
    public String goorgFace(String username, Model model){
        int number=intoOrgService.intoNumber(username);
        List<Org> orgs = new ArrayList<>();
        if(number!=0) {
            List<IntoOrg> intoOrgs = intoOrgService.getOrgList(username,0,10);
            for (IntoOrg intoOrg : intoOrgs) {
                Org org=orgService.getOrg(intoOrg.getOrg_id());
                orgs.add(org);
            }
        }
        model.addAttribute("username",username);
        model.addAttribute("orgs",orgs);
        model.addAttribute("number",number);
        return "orgFace";
    }
    @RequestMapping("/golimitorg")
    public void golimitorg(String username, int begin, int end, HttpServletResponse response,Model model) throws IOException {
        int number=intoOrgService.intoNumber(username);
        List<Org> orgs = new ArrayList<>();
        if(number>begin) {
            List<IntoOrg> intoOrgs = intoOrgService.getOrgList(username,begin,end);
            for (IntoOrg intoOrg : intoOrgs) {
                Org org=orgService.getOrg(intoOrg.getOrg_id());
                orgs.add(org);
            }
        }
        model.addAttribute("orgs",orgs);
        System.out.println(orgs);
        String liststr= JSON.toJSONString(orgs);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/getorginformation")
    public void getOrgInformation(String gropid, HttpServletResponse response) throws IOException {
        Org org=orgService.getOrg(gropid);
        List<IntoOrg> intoOrgs=intoOrgService.getInto_User_List(gropid);
        List<User> users=new ArrayList<>();
        for(IntoOrg intoOrg:intoOrgs)
        {
            users.add(userService.getUser(intoOrg.getUsername()));
        }
        Map map=new HashMap();
        map.put("org",org);
        map.put("users",users);
        String liststr= JSON.toJSONString(map);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(liststr);
    }
    @RequestMapping("/addorg")
    public void addOrg(String org_id,String username,HttpServletResponse response) throws IOException {
        if(!orgService.orgIsExit(org_id)){
            response.getWriter().write("no");
        }
        else{
            intoOrgService.intoOrg(org_id,username);
            orgService.intoOrg(org_id);
            response.getWriter().write("yes");
        }
    }
    @RequestMapping("/exitorg")
    public void exitOrg(String org_id,String username,HttpServletResponse response) throws IOException {
        intoOrgService.exitOrg(org_id,username);
        orgService.exitOrg(org_id);
        response.getWriter().write("yes");
    }
    @RequestMapping("/isInOrg")
    public void isInOrg(String org_id,String username,HttpServletResponse response) throws IOException {
        if(intoOrgService.isIntoOrg(org_id,username))
        {
            response.getWriter().write("y");
        }
        else{
            response.getWriter().write("n");
        }
    }
}
