package com.controller;
import com.pojo.CourseWork;
import com.pojo.IntoWork;
import com.pojo.User;
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
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
@Controller
public class WorkManInfController {
    @Autowired
    @Qualifier("CourseWorkService")
    com.service.CourseWorkService courseWorkService;
    @Autowired
    @Qualifier("IntoWorkService")
    com.service.IntoWorkService intoWorkService;
    @Autowired
    @Qualifier("UserService")
    com.service.UserService userService;
    @RequestMapping("/goWorkManInf")
    public String goWorkManInf(String username, String course_id, int work_id,
                               Model model) {
        course_id = "#" + course_id;
        CourseWork courseWork = courseWorkService.getWork(course_id, work_id);
        List<User> users = new ArrayList<>();
        List<IntoWork> workALLInto = intoWorkService.getWorkALLInto(course_id, work_id);
        if (intoWorkService.exsistUser(course_id, work_id)) {
            List<String> workAllUsername = intoWorkService.getWorkAllUsername(course_id, work_id);
            for (String s : workAllUsername) {
                users.add(userService.getUser(s));
            }
        }
        model.addAttribute("course_id", course_id);
        model.addAttribute("username", username);
        model.addAttribute("courseWork", courseWork);
        model.addAttribute("users", users);
        model.addAttribute("intoworks", workALLInto);
        return "workManInf";
    }
    @RequestMapping("/updateWorkName")
    public void updateWorkName(String work_name, String course_id, int work_id, HttpServletResponse response) throws IOException {
        courseWorkService.updateCourseWorkName(course_id, work_id, work_name);
        response.getWriter().write("ok");
    }
    @RequestMapping("/updateWorkContent")
    public void updateWorkContent(String work_content, String course_id, int work_id, HttpServletResponse response) throws IOException {
        courseWorkService.updateCourseWorkContent(course_id, work_id, work_content);
        response.getWriter().write("ok");
    }
    @RequestMapping("/addUserToWork")
    public void addUserToWork(String username, String course_id, int work_id, HttpServletResponse response) throws IOException {
        if (userService.isexsist(username) == 0)
            response.getWriter().write("no1");
        else if (intoWorkService.userExsistInWork(course_id, work_id, username))
            response.getWriter().write("no2");
        else {
            IntoWork intoWork = new IntoWork(course_id, work_id, username, 0, null,null);
            intoWorkService.createIntowWork(intoWork);
            response.getWriter().write("ok");
        }
    }
    @RequestMapping("/deleteUserFromWork")
    public void deleteUserFromWork(String username, String course_id, int work_id, HttpServletResponse response) throws IOException {
        intoWorkService.deleteUserFromWork(course_id, work_id, username);
        response.getWriter().write("ok");
    }

    @RequestMapping("/downloadWorkFile")
    public void downloadWorkFile(String filename, String course_id, int work_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("uploads")
                + "\\" + "work" + "\\" + course_id + "\\" + work_id + "\\" + filename;
        File file = new File(path);
        System.out.println("==========" + path);
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        filename = URLEncoder.encode(filename, "UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
    @RequestMapping("/updateWorkFile")
    public void updateWorkFile(@RequestParam("file") MultipartFile file, String course_id, int work_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String rootPath = request.getSession().getServletContext().getRealPath("uploads/work/");
        String newFileName = originalFilename;
        String deletepath = rootPath + File.separator + course_id + File.separator + work_id;
        DeleteFile.deleteDir(new File(deletepath));
        File newFile = new File(rootPath + File.separator + course_id + File.separator + work_id + File.separator + newFileName);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        courseWorkService.updateFile(course_id, work_id, originalFilename);
        response.getWriter().write("ok");
    }
    @RequestMapping("/deleteWork")
    public void deleteWork( String course_id, int work_id, HttpServletResponse response) throws IOException {
        courseWorkService.deleteWork(course_id,work_id);
        intoWorkService.deleteWork(course_id,work_id);
        response.getWriter().write("ok");
    }
    @RequestMapping("/AllWorkDownload")
    public void AllWorkDownload(String course_id, int work_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        FileInputStream fis = null;
        String path = request.getSession().getServletContext().getRealPath("uploads")
                + "\\" + "finishWork" + "\\" + course_id + "\\" + work_id;
        String zipFilePath = request.getSession().getServletContext().getRealPath("uploads")
                + "\\" + "zipWork" + "\\" + course_id + "\\" + work_id;
        String deletepath =request.getSession().getServletContext().getRealPath("uploads")
                + "\\" + "zipWork" + "\\" + course_id;
        DeleteFile.deleteDir(new File(deletepath));
        File file = new File(path);
        File zipFile = new File(zipFilePath + "\\" + work_id + ".zip");
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }
        if (!file.exists()  && !file.isDirectory()) {
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('NO User Sumbit!');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        } else {
            File[] files = file.listFiles();
            if(null == files || files.length<1){
                PrintWriter out = response.getWriter();
                out.println("<script>");
                out.println("alert('NO User Sumbit!');");
                out.println("history.back();");
                out.println("</script>");
                out.close();
            } else {
                InputStream bis = null;
                fos = new FileOutputStream(zipFile);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                byte[] bufs = new byte[1024*10];
                for (File value : files) {//创建ZIP实体，并添加进压缩包
                    value=value.listFiles()[0];
                    ZipEntry zipEntry = new ZipEntry(value.getName());
                    zos.putNextEntry(zipEntry);//读取待压缩的文件并写进压缩包里
                    fis = new FileInputStream(value);
                    bis = new BufferedInputStream(fis, 1024 * 10);
                    int read = 0;
                    while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                        zos.write(bufs, 0, read);
                    }
                }
                if(null != bis) bis.close();
                if(null != zos) zos.close();
                InputStream bis1 = new BufferedInputStream(new FileInputStream(zipFile));
                String filename = URLEncoder.encode(work_id+".zip", "UTF-8");
                response.addHeader("Content-Disposition", "attachment;filename=" + filename);
                response.setContentType("multipart/form-data");
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                int len = 0;
                while ((len = bis1.read()) != -1) {
                    out.write(len);
                    out.flush();
                }
                out.close();
            }
        }
    }
    @RequestMapping("/downloadOneUserWork")
    public void downloadOneUserWork(String filename,String username ,String course_id, int work_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("uploads")
                + "\\" + "finishWork" + "\\" + course_id + "\\" + work_id + "\\" +username+"\\"+ filename;
        File file = new File(path);
        System.out.println("==========" + path);
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        filename = URLEncoder.encode(filename, "UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
