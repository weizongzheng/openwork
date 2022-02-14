package com.service;
import com.pojo.Course;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CourseInter {
    int createCourseNumber(String username );
    String gettitle(String course_id);
    String getCreateUsername( String course_id);
    Course getCourse(String course_id);
    int exitCourse(String courseid);
    boolean CourseIsExists( String courseid);
    int createCourse(Course course);
    List<Course> getUserAllCourse(String username);
    int updateName(String course_id,String name);
    int updateContent( String course_id, String content);
    int deleteCourse(String course_id);
}
