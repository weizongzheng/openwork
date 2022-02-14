package com.controller;
import com.pojo.CourseWork;
import com.pojo.IntoWork;
import com.utils.DeleteFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
public class SubmitController {
    @Autowired
    @Qualifier("CourseWorkService")
    com.service.CourseWorkService courseWorkService;
    @Autowired
    @Qualifier("IntoWorkService")
    com.service.IntoWorkService intoWorkService;
    @Autowired
    @Qualifier("UserService")
    com.service.UserService userService;
    @RequestMapping("/goSubmit")
    public String goSubmit(String username, String course_id, int work_id, Model model){
        course_id="#"+course_id;
        IntoWork intoWork = intoWorkService.getIntoWork(course_id, work_id, username);
        CourseWork courseWork = courseWorkService.getWork(course_id, work_id);
        model.addAttribute("course_id",course_id);
        model.addAttribute("username",username);
        model.addAttribute("user",userService.getUser(username));
        model.addAttribute("courseWork",courseWork);
        model.addAttribute("intoWork",intoWork);
        return "Submit";
    }
    @RequestMapping("/submitWork")
    public void submitWork(@RequestParam("file") MultipartFile file, String username, String course_id,
                           int work_id,String content ,HttpServletRequest request, HttpServletResponse response) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String rootPath = request.getSession().getServletContext().getRealPath("uploads/finishWork/");
        String newFileName =  originalFilename;
        File newFile = new File(rootPath + File.separator + course_id + File.separator+work_id+File.separator+username+File.separator + newFileName);
        if( !newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        intoWorkService.submitWork(course_id,work_id,username,originalFilename,content);
        file.transferTo(newFile);
        String fileUrl = course_id+ "/"+work_id+ "/"+ newFileName;
        System.out.println(originalFilename);
        response.getWriter().write(fileUrl);
    }
    @RequestMapping("/updateSubmitWork")
    public void updateSubmitWork(@RequestParam("file") MultipartFile file, String course_id, int work_id,
                                 String username,String content,HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String rootPath = request.getSession().getServletContext().getRealPath("uploads/finishWork/");
        String newFileName = originalFilename;
        String deletepath = rootPath + File.separator + course_id + File.separator + work_id+File.separator+username;
        DeleteFile.deleteDir(new File(deletepath));
        File newFile = new File(rootPath + File.separator + course_id + File.separator + work_id + File.separator +username+File.separator+ newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        intoWorkService.updateSubmitWork(course_id,work_id,username,originalFilename,content);
        response.getWriter().write("ok");
    }
    @RequestMapping("/updateSubmitWorkNofile")
    public void updateSubmitWorkNofile( String course_id, int work_id,
                                 String username,String content,HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        intoWorkService.updateSubmitWorkNoFile(course_id,work_id,username,content);
        response.getWriter().write("ok");
    }
}
