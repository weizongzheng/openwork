package com.service;
import com.dao.IntoOrgDao;
import com.pojo.IntoOrg;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class IntoOrgService implements IntoOrgInter{
    private IntoOrgDao intoOrgDao;
    public IntoOrgDao getIntoOrgDao() {
        return intoOrgDao;
    }
    public void setIntoOrgDao(IntoOrgDao intoOrgDao) {
        this.intoOrgDao = intoOrgDao;
    }
    @Override
    public List<IntoOrg> getOrgList(String username, int begin, int end) {
        return intoOrgDao.getOrgList(username,begin,end);
    }
    @Override
    public int intoNumber(String username) {
        return intoOrgDao.intoNumber(username);
    }
    @Override
    public List<IntoOrg> getInto_User_List(String org_id) {
        return intoOrgDao.getInto_User_List(org_id);
    }
    @Override
    public int intoOrg(String org_id, String username) {
        return intoOrgDao.intoOrg(org_id,username);
    }
    @Override
    public int exitOrg(String org_id, String username) {
        return intoOrgDao.exitOrg(org_id,username);
    }
    @Override
    public boolean isIntoOrg(String org_id, String username) {
        return (intoOrgDao.isIntoOrg(org_id,username)==1);
    }
    @Override
    public int ListintoOrg(String org_id, List<String> usernames) {
        return intoOrgDao.ListintoOrg(org_id,usernames);
    }
    @Override
    public int mandatoryDeleteUser(String org_id, String username) {
        return intoOrgDao.mandatoryDeleteUser(org_id,username);
    }
    @Override
    public int deleteOrg(String org_id) {
        return intoOrgDao.deleteOrg(org_id);
    }
    @Override
    public List<IntoOrg> getUserAllOrg(String username) {
        return intoOrgDao.getUserAllOrg(username);
    }
    @Override
    public int getOrg_UserNumber(String org_id) {
        return intoOrgDao.getOrg_UserNumber(org_id);
    }
}
