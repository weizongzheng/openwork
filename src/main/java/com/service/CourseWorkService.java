package com.service;
import com.dao.CourseWorkDao;
import com.pojo.CourseWork;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseWorkService implements CourseWorkInter{
    private CourseWorkDao courseWorkDao;
    public CourseWorkDao getCourseWorkDao() {
        return courseWorkDao;
    }
    public void setCourseWorkDao(CourseWorkDao courseWorkDao) {
        this.courseWorkDao = courseWorkDao;
    }
    @Override
    public List<CourseWork> getCourseAllWork(String course_id) {
        return courseWorkDao.getCourseAllWork(course_id);
    }
    @Override
    public int createCourseWork(CourseWork courseWork) {
        return courseWorkDao.createCourseWork(courseWork);
    }
    @Override
    public boolean exsistWork(String course_id) {
        return (!(courseWorkDao.exsistWork(course_id)==0));
    }
    @Override
    public int getCourseMaxWork_id(String course_id) {
        return courseWorkDao.getCourseMaxWork_id(course_id);
    }
    @Override
    public int setWork_id(String course_id) {
        if(!exsistWork(course_id))
            return 1;
        else
            return (getCourseMaxWork_id(course_id)+1);
    }
    @Override
    public CourseWork getWork(String course_id, int work_id) {
        return courseWorkDao.getWork(course_id,work_id);
    }
    @Override
    public int updateCourseWorkName(String course_id, int work_id, String work_name) {
        return courseWorkDao.updateCourseWorkName(course_id,work_id,work_name);
    }
    @Override
    public int updateCourseWorkContent(String course_id, int work_id, String work_content) {
        return courseWorkDao.updateCourseWorkContent(course_id,work_id,work_content);
    }
    @Override
    public int updateFile(String course_id, int work_id, String file) {
        return courseWorkDao.updateFile(course_id,work_id,file);
    }
    @Override
    public int deleteWork(String course_id, int work_id) {
        return courseWorkDao.deleteWork(course_id,work_id);
    }
    @Override
    public int deleteCourseAllWork(String course_id) {
        return courseWorkDao.deleteCourseAllWork(course_id);
    }
}
