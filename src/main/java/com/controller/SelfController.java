package com.controller;
import com.pojo.User;
import com.pojo.profilePictures;
import com.service.UserService;
import com.service.profilePicturesService;
import com.utils.DeleteFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
@Controller
public class SelfController {
    @Autowired
    @Qualifier("UserService")
    UserService userService;
    @Autowired
    @Qualifier("profilePicturesService")
    profilePicturesService picturesService;
    @RequestMapping("/goself")
    public String goselfinformatin(String username, Model model){
        User user=userService.getUser(username);
        String p=picturesService.getPicture(username);
        model.addAttribute("pUrl","uploads/img/"+username+"/"+p);
        model.addAttribute("username",username);
        model.addAttribute("user",user);
        return "selfinformation";
    }
    @RequestMapping("/subImag")
    public void subImag(@RequestParam("img") MultipartFile img, String username, HttpServletResponse response,
                        HttpServletRequest request) throws IOException {
        String originalFilename = img.getOriginalFilename();
        String rootPath = request.getSession().getServletContext().getRealPath("uploads/img/");
        String newFileName = originalFilename;
        String deletepath = rootPath + File.separator + username ;
        if((new File(deletepath)).exists())
        DeleteFile.deleteDir(new File(deletepath));
        File newFile = new File(rootPath +File.separator + username+ File.separator+ newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        if(!picturesService.isCreatePicture(username))
            picturesService.createPicture(new profilePictures(username,originalFilename));
        else{
            picturesService.updatePicture(new profilePictures(username,originalFilename));
        }
        img.transferTo(newFile);
        response.getWriter().write("ok");
    }
}
