package com.dao;
import com.pojo.CourseMessage;
import com.pojo.FriendMessage;
import com.pojo.IntoClass;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface CourseMessageDao {
    int countNumber(@Param("username") String username, @Param("readed")  int readed);
    List<CourseMessage> getCourseMeList(@Param("username") String username, @Param("readed")  int readed);
    int readIt(@Param("username") String username, @Param("creat") Date creat, @Param("m_username") String m_username);
    CourseMessage getCourseMessage(@Param("course_id") String course_id,
                           @Param("username") String username,
                           @Param("create")Date create,
                           @Param("readed") int readed);
    int readCourseMessage(@Param("username") String username, @Param("creat") Date creat, @Param("course_id") String course_id);
    int deleteCourseMessage(@Param("username") String username, @Param("creat") Date creat, @Param("course_id") String course_id);
    int createCourseMessage(CourseMessage courseMessage);
    int deleteCourseAllMessage(@Param("course_id") String course_id);
}
