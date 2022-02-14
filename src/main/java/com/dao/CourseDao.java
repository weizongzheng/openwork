package com.dao;
import com.pojo.Course;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface CourseDao {
    int createCourseNumber(@Param("username") String username );
    String gettitle(@Param("course_id") String course_id);
    String getCreateUsername(@Param("course_id") String course_id);
    Course getCourse(@Param("course_id") String course_id);
    int exitCourse(@Param("courseid") String courseid);
    int CourseIsExists(@Param("courseid") String courseid);
    int createCourse(Course course);
    List<Course> getUserAllCourse(@Param("username") String username);
    int updateName(@Param("course_id") String course_id,@Param("name") String name);
    int updateContent(@Param("course_id") String course_id,@Param("content") String content);
    int deleteCourse(@Param("course_id") String course_id);
}
