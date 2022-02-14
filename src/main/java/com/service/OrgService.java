package com.service;
import com.dao.OrgDao;
import com.pojo.Org;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrgService implements OrgInter{
    OrgDao orgDao;
    public OrgDao getOrgDao() {
        return orgDao;
    }
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }
    @Override
    public String getOrgName(String org_id) {
        return orgDao.getOrgName(org_id);
    }
    @Override
    public String getCreateOrgUsername(String org_id) {
        return orgDao.getCreateOrgUsername(org_id);
    }
    @Override
    public Org getOrg(String org_id) {
        return orgDao.getOrg(org_id);
    }
    @Override
    public boolean orgIsExit(String org_id) {
        return (orgDao.orgIsExit(org_id)==1);
    }
    @Override
    public int intoOrg(String org_id) {
        return orgDao.intoOrg(org_id);
    }
    @Override
    public int exitOrg(String org_id) {
        return orgDao.exitOrg(org_id);
    }
    @Override
    public int createOrg(Org org) {
        return orgDao.createOrg(org);
    }
    @Override
    public List<Org> getUserAllOrg(String username) {
        return orgDao.getUserAllOrg(username);
    }
    @Override
    public int updateContent(String org_id, String content) {
        return orgDao.updateContent(org_id,content);
    }
    @Override
    public int updateName(String org_id, String name) {
        return orgDao.updateName(org_id,name);
    }
    @Override
    public int deleteOrg(String org_id) {
        return orgDao.deleteOrg(org_id);
    }
}
