package com.dao;
import com.pojo.CourseWork;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface CourseWorkDao {
    List<CourseWork> getCourseAllWork(@Param("course_id") String course_id);
    int createCourseWork(CourseWork courseWork);
    int exsistWork(@Param("course_id")  String course_id);
    int getCourseMaxWork_id(@Param("course_id")  String course_id);
    CourseWork getWork(@Param("course_id") String course_id,@Param("work_id") int work_id);
    int updateCourseWorkName(@Param("course_id") String course_id,
                             @Param("work_id") int work_id,
                             @Param("work_name") String work_name);
    int updateCourseWorkContent(@Param("course_id") String course_id,
                             @Param("work_id") int work_id,
                             @Param("work_content") String work_content);
    int updateFile(@Param("course_id") String course_id,
                   @Param("work_id") int work_id,
                   @Param("file") String file);
    int deleteWork(@Param("course_id") String course_id,@Param("work_id") int work_id);
    int deleteCourseAllWork(@Param("course_id") String course_id);
}
