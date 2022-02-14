package com.service;
import com.pojo.OrgMessage;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface OrgMessageInter {
    int countNumber(String username, int readed);
    List<OrgMessage> getOrgMeList( String username,  int readed);
    int readIt(String username, Date creat, String m_username);
    OrgMessage getOrgMessage( String username, String org_id,
                             int readed, Date create_time);
    int deleteOrgMessage( String username,  Date creat,  String org_id);
    int createOrgMessage(OrgMessage orgMessage);
    int deleteOrgAllMessage( String org_id);
}
