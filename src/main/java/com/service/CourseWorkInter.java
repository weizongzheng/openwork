package com.service;
import com.pojo.CourseWork;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CourseWorkInter {
    List<CourseWork> getCourseAllWork( String course_id);
    int createCourseWork(CourseWork courseWork);
    boolean exsistWork( String course_id);
    int getCourseMaxWork_id( String course_id);
    int setWork_id( String course_id);
    CourseWork getWork(String course_id, int work_id);
    int updateCourseWorkName(String course_id, int work_id, String work_name);
    int updateCourseWorkContent( String course_id, int work_id, String work_content);
    int updateFile( String course_id, int work_id, String file);
    int deleteWork( String course_id,  int work_id);
    int deleteCourseAllWork( String course_id);
}
