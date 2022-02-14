package com.service;
import com.dao.CourseMessageDao;
import com.pojo.CourseMessage;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
@Service
public class CourseMessageService implements CourseMessageInter{
    CourseMessageDao courseMessageDao;
    public CourseMessageDao getCourseMessageDao() {
        return courseMessageDao;
    }
    public void setCourseMessageDao(CourseMessageDao courseMessageDao) {
        this.courseMessageDao = courseMessageDao;
    }
    @Override
    public int countNumber(String username, int readed) {
        return courseMessageDao.countNumber(username,readed);
    }
    @Override
    public List<CourseMessage> getCourseMeList(String username, int readed) {
        return courseMessageDao.getCourseMeList(username,readed);
    }
    @Override
    public int readIt(String username, Date creat, String m_username) {
        return courseMessageDao.readIt(username,creat,m_username);
    }
    @Override
    public CourseMessage getCourseMessage(String course_id, String username, Date create, int readed) {
        return courseMessageDao.getCourseMessage(course_id,username,create,readed);
    }
    @Override
    public int readCourseMessage(String username, Date creat, String course_id) {
        return courseMessageDao.readCourseMessage(username,creat,course_id);
    }
    @Override
    public int deleteCourseMessage(String username, Date creat, String course_id) {
        return courseMessageDao.deleteCourseMessage(username,creat,course_id);
    }
    @Override
    public int createCourseMessage(CourseMessage courseMessage) {
        return courseMessageDao.createCourseMessage(courseMessage);
    }
    @Override
    public int deleteCourseAllMessage(String course_id) {
        return courseMessageDao.deleteCourseAllMessage(course_id);
    }
}
