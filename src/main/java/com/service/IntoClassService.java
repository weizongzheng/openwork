package com.service;
import com.dao.IntoClassDao;
import com.pojo.IntoClass;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
@Service
public class IntoClassService implements IntoClassInter{
    IntoClassDao intoClassDao;
    public IntoClassDao getIntoClassDao() {
        return intoClassDao;
    }
    public void setIntoClassDao(IntoClassDao intoClassDao) {
        this.intoClassDao = intoClassDao;
    }
    @Override
    public int intoClassNumber(String username) {
        return intoClassDao.intoClassNumber(username);
    }
    @Override
    public List<IntoClass> getCourseList(String username, int begin, int end) {
        return intoClassDao.getCourseList(username,begin,end);
    }
    @Override
    public List<IntoClass> getInto_User_List(String course_id) {
        return intoClassDao.getInto_User_List(course_id);
    }
    @Override
    public boolean isIntoCourse(String course_id, String username) {
        return (intoClassDao.isIntoCourse(course_id,username)==1);
    }
    @Override
    public int exitCourse(String courseid, String username) {
        return intoClassDao.exitCourse(courseid,username);
    }
    @Override
    public int intoClass(IntoClass intoClass) {
        return intoClassDao.intoClass(intoClass);
    }
    @Override
    public boolean be_deleted(String courseid, String username) {
        return (intoClassDao.be_deleted(courseid,username)==1);
    }
    @Override
    public int intoFriendClass(Set<String> listfriend, String course_id) {
        return intoClassDao.intoFriendClass(listfriend,course_id);
    }
    @Override
    public int mandatoryDeleteUser(String course_id, String username) {
        return intoClassDao.mandatoryDeleteUser(course_id,username);
    }
    @Override
    public int deleteCourse(String course_id) {
        return intoClassDao.deleteCourse(course_id);
    }
    @Override
    public List<String> getInto_Username_List(String course_id) {
        return intoClassDao.getInto_Username_List(course_id);
    }
}
