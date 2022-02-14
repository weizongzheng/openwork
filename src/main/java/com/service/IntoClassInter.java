package com.service;
import com.pojo.IntoClass;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Set;
public interface IntoClassInter {
    int intoClassNumber( String username );
    List<IntoClass> getCourseList( String username, int begin, int end);
    List<IntoClass> getInto_User_List(String course_id);
    boolean isIntoCourse(String course_id, String username);
    int exitCourse( String courseid, String username);
    int intoClass(IntoClass intoClass);
    boolean be_deleted( String courseid, String username);
    int intoFriendClass(Set<String> listfriend, String course_id);
    int mandatoryDeleteUser( String course_id,String username);
    int deleteCourse( String course_id);
    List<String> getInto_Username_List( String course_id);
}
