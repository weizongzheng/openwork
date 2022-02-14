package com.service;
import com.pojo.CourseMessage;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface CourseMessageInter {
    int countNumber(String username,  int readed);
    List<CourseMessage> getCourseMeList( String username,  int readed);
    int readIt(String username,Date creat, String m_username);
    CourseMessage getCourseMessage(String course_id, String username, Date create, int readed);
    int readCourseMessage(String username, Date creat, String course_id);
    int deleteCourseMessage( String username, Date creat, String course_id);
    int createCourseMessage(CourseMessage courseMessage);
    int deleteCourseAllMessage( String course_id);
}
