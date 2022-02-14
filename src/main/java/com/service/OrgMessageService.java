package com.service;
import com.dao.OrgMessageDao;
import com.pojo.OrgMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrgMessageService implements OrgMessageInter{
    OrgMessageDao orgMessageDao;
    public OrgMessageDao getOrgMessageDao() {
        return orgMessageDao;
    }
    public void setOrgMessageDao(OrgMessageDao orgMessageDao) {
        this.orgMessageDao = orgMessageDao;
    }
    @Override
    public int countNumber(String username, int readed) {
        return orgMessageDao.countNumber(username,readed);
    }
    @Override
    public List<OrgMessage> getOrgMeList(String username, int readed) {
        return orgMessageDao.getOrgMeList(username,readed);
    }
    @Override
    public int readIt(String username, Date creat, String m_username) {
        return orgMessageDao.readIt(username,creat,m_username);
    }
    @Override
    public OrgMessage getOrgMessage(String username, String org_id, int readed, Date create_time) {
        return orgMessageDao.getOrgMessage(username,org_id,readed,create_time);
    }
    @Override
    public int deleteOrgMessage(String username, Date creat, String org_id) {
        return orgMessageDao.deleteOrgMessage(username,creat,org_id);
    }
    @Override
    public int createOrgMessage(OrgMessage orgMessage) {
        return orgMessageDao.createOrgMessage(orgMessage);
    }
    @Override
    public int deleteOrgAllMessage(String org_id) {
        return orgMessageDao.deleteOrgAllMessage(org_id);
    }
}
