package com.dao;
import com.pojo.IntoClass;
import com.pojo.IntoOrg;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
import java.util.Set;
public interface IntoClassDao {
    int intoClassNumber(@Param("username") String username);
    List<IntoClass> getCourseList(@Param("username") String username, @Param("begin") int begin, @Param("end") int end);
    List<IntoClass> getInto_User_List(@Param("course_id") String course_id);
    int exitCourse(@Param("courseid") String courseid,@Param("username") String username);
    int isIntoCourse(@Param("course_id") String course_id,@Param("username") String username);
    int intoClass(IntoClass intoClass);
    int be_deleted(@Param("courseid") String courseid,@Param("username") String username);
    int intoFriendClass(@Param("usernames") Set<String> listfriend, @Param("course_id") String course_id);
    int mandatoryDeleteUser(@Param("course_id") String course_id,@Param("username") String username);
    int deleteCourse(@Param("course_id") String course_id);
    List<String> getInto_Username_List(@Param("course_id") String course_id);
}
