package com.controller;
import com.pojo.Course;
import com.pojo.CourseMessage;
import com.pojo.CourseWork;
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
import java.util.Date;
import java.util.List;
@Controller
public class MyCourseController {
    @Autowired
    @Qualifier("CourseService")
    com.service.CourseService courseService;
    @Autowired
    @Qualifier("IntoClassService")
    com.service.IntoClassService intoClassService;
    @Autowired
    @Qualifier("IntoWorkService")
    com.service.IntoWorkService intoWorkService;
    @Autowired
    @Qualifier("CourseWorkService")
    com.service.CourseWorkService courseWorkService;
    @Autowired
    @Qualifier("CourseMessageService")
    com.service.CourseMessageService courseMessageService;
    @RequestMapping("/IntoMyCourse")
    public String IntoMyCourse(String username, String course_id, Model model) {
        course_id="#"+course_id;
        Course course=courseService.getCourse(course_id);
        List<CourseWork> courseAllWork = courseWorkService.getCourseAllWork(course_id);
        model.addAttribute("username",username);
        model.addAttribute("isCreate",username.equals(course.getCreate_user()));
        model.addAttribute("courseAllWork",courseAllWork);
        model.addAttribute("course",courseService.getCourse(course_id));
        return "MyCourse";
    }
    @RequestMapping("/createWork")
    public void createWork(@RequestParam("file") MultipartFile file, String course_id, String work_name, String work_content, HttpServletResponse response,HttpServletRequest request) throws IOException {
        int work_id=courseWorkService.setWork_id(course_id);
        List<String> usernameList=intoClassService.getInto_Username_List(course_id);
        CourseWork courseWork=new CourseWork(course_id,work_id,work_name,work_content,"");
        String originalFilename = file.getOriginalFilename();
        String rootPath = request.getSession().getServletContext().getRealPath("uploads/work/");
        String newFileName =  originalFilename;
        File newFile = new File(rootPath + File.separator + course_id + File.separator+work_id+File.separator + newFileName);
        if( !newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        file.transferTo(newFile);
        String fileUrl = course_id+ "/"+work_id+ "/"+ newFileName;
        courseWork.setFile(originalFilename);
        courseWorkService.createCourseWork(courseWork);
        intoWorkService.createWorkAllUser(usernameList,course_id,work_id);
        for(String s:usernameList)
        {
            CourseMessage message=new CourseMessage(course_id,s,new Date(),0,
                    "您的课程"+course_id+"发布新的作业，请注意提交！");
            courseMessageService.createCourseMessage(message);
        }
        System.out.println(originalFilename);
        response.getWriter().write(fileUrl);
    }
}
