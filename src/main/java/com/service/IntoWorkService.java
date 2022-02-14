package com.service;
import com.dao.IntoWorkDao;
import com.pojo.IntoWork;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IntoWorkService implements IntoWorkInter{
    private IntoWorkDao intoWorkDao;
    public IntoWorkDao getIntoWorkDao() {
        return intoWorkDao;
    }
    public void setIntoWorkDao(IntoWorkDao intoWorkDao) {
        this.intoWorkDao = intoWorkDao;
    }
    @Override
    public int createWorkAllUser(List<String> usernames, String course_id, int work_id) {
        return intoWorkDao.createWorkAllUser(usernames,course_id,work_id);
    }
    @Override
    public List<String> getWorkAllUsername(String course_id, int work_id) {
        return intoWorkDao.getWorkAllUsername(course_id,work_id);
    }
    @Override
    public boolean exsistUser(String course_id, int work_id) {
        return (!(intoWorkDao.exsistUser(course_id,work_id)==0));
    }
    @Override
    public List<IntoWork> getWorkALLInto(String course_id, int work_id) {
        return intoWorkDao.getWorkALLInto(course_id,work_id);
    }
    @Override
    public boolean userExsistInWork(String course_id, int work_id, String username) {
        return (intoWorkDao.userExsistInWork(course_id,work_id,username)==1);
    }
    @Override
    public int createIntowWork(IntoWork intoWork) {
        return intoWorkDao.createIntowWork(intoWork);
    }
    @Override
    public int deleteUserFromWork(String course_id, int work_id, String username) {
        return intoWorkDao.deleteUserFromWork(course_id,work_id,username);
    }
    @Override
    public int submitWork(String course_id, int work_id, String username, String file,String content) {
        return intoWorkDao.submitWork(course_id,work_id,username,file,content);
    }
    @Override
    public IntoWork getIntoWork(String course_id, int work_id, String username) {
        return intoWorkDao.getIntoWork(course_id,work_id,username);
    }
    @Override
    public int updateSubmitWork(String course_id, int work_id, String username, String file, String content) {
        return intoWorkDao.updateSubmitWork(course_id,work_id,username,file,content);
    }
    @Override
    public int deleteWork(String course_id, int work_id) {
        return intoWorkDao.deleteWork(course_id,work_id);
    }
    @Override
    public int deleteCourse_ALLWork(String course_id) {
        return intoWorkDao.deleteCourse_ALLWork(course_id);
    }
    @Override
    public int updateSubmitWorkNoFile(String course_id, int work_id, String username, String content) {
        return intoWorkDao.updateSubmitWorkNoFile(course_id,work_id,username,content);
    }
}
