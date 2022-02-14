package com.dao;
import com.pojo.IntoWork;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface IntoWorkDao {
    int createWorkAllUser(@Param("usernames") List<String> usernames,
                          @Param("course_id") String course_id,
                          @Param("work_id") int work_id);
   List<String> getWorkAllUsername(@Param("course_id") String course_id,
                                   @Param("work_id") int work_id);
   int exsistUser(@Param("course_id") String course_id,
                                    @Param("work_id") int work_id);
    List<IntoWork> getWorkALLInto(@Param("course_id") String course_id,
                                  @Param("work_id") int work_id);
    int userExsistInWork(@Param("course_id") String course_id,
                         @Param("work_id") int work_id,
                         @Param("username") String username);
    int createIntowWork(IntoWork intoWork);
    int deleteUserFromWork(@Param("course_id") String course_id,
                         @Param("work_id") int work_id,
                         @Param("username") String username);
    int submitWork(@Param("course_id") String course_id,
                   @Param("work_id") int work_id,
                   @Param("username") String username,
                   @Param("file") String file,
                   @Param("content") String content);
    int updateSubmitWork(@Param("course_id") String course_id,
                   @Param("work_id") int work_id,
                   @Param("username") String username,
                   @Param("file") String file,
                   @Param("content") String content);
    int updateSubmitWorkNoFile(@Param("course_id") String course_id,
                         @Param("work_id") int work_id,
                         @Param("username") String username,
                         @Param("content") String content);
    IntoWork getIntoWork(@Param("course_id") String course_id,
                   @Param("work_id") int work_id,
                   @Param("username") String username);
    int deleteWork(@Param("course_id") String course_id,@Param("work_id") int work_id);
    int deleteCourse_ALLWork(@Param("course_id") String course_id);
}
