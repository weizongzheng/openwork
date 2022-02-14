package com.service;
import com.dao.CourseDao;
import com.pojo.Course;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseService implements CourseInter{
    CourseDao courseDao;
    public CourseDao getCourseDao() {
        return courseDao;
    }
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
    @Override
    public int createCourseNumber(String username) {
        return courseDao.createCourseNumber(username);
    }
    @Override
    public String gettitle(String course_id) {
        return courseDao.gettitle(course_id);
    }
    @Override
    public String getCreateUsername(String course_id) {
        return courseDao.getCreateUsername(course_id);
    }
    @Override
    public Course getCourse(String course_id) {
        return courseDao.getCourse(course_id);
    }
    @Override
    public int exitCourse(String courseid) {
        return courseDao.exitCourse(courseid);
    }
    @Override
    public boolean CourseIsExists(String courseid) {
        return (courseDao.CourseIsExists(courseid)==1);
    }
    @Override
    public int createCourse(Course course) {
        return courseDao.createCourse(course);
    }
    @Override
    public List<Course> getUserAllCourse(String username) {
        return courseDao.getUserAllCourse(username);
    }
    @Override
    public int updateName(String course_id, String name) {
        return courseDao.updateName(course_id,name);
    }
    @Override
    public int updateContent(String course_id, String content) {
        return courseDao.updateContent(course_id,content);
    }
    @Override
    public int deleteCourse(String course_id) {
        return courseDao.deleteCourse(course_id);
    }
}
