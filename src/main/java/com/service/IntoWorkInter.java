package com.service;
import com.pojo.IntoWork;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface IntoWorkInter {
    int createWorkAllUser( List<String> usernames, String course_id, int work_id);
    List<String> getWorkAllUsername( String course_id, int work_id);
    boolean exsistUser( String course_id, int work_id);
    List<IntoWork> getWorkALLInto(String course_id, int work_id);
    boolean userExsistInWork( String course_id, int work_id, String username);
    int createIntowWork(IntoWork intoWork);
    int deleteUserFromWork( String course_id, int work_id, String username);
    int submitWork(String course_id, int work_id, String username, String file,String content );
    IntoWork getIntoWork( String course_id, int work_id, String username);
    int updateSubmitWork(String course_id, int work_id, String username, String file, String content);
    int deleteWork( String course_id,int work_id);
    int deleteCourse_ALLWork( String course_id);
    int updateSubmitWorkNoFile( String course_id, int work_id, String username, String content);
}
