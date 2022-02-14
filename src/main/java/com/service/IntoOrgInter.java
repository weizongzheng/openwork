package com.service;
import com.pojo.IntoOrg;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface IntoOrgInter {
    List<IntoOrg> getOrgList(String username, int begin, int end);
    int intoNumber( String username);
    List<IntoOrg> getInto_User_List( String org_id);
    int intoOrg(String org_id,String username);
    int exitOrg( String org_id,String username);
    boolean isIntoOrg(String org_id, String username);
    int ListintoOrg(String org_id, List<String> usernames);
    int mandatoryDeleteUser(String org_id, String username);
    int deleteOrg( String org_id);
    List<IntoOrg> getUserAllOrg( String username);
    int getOrg_UserNumber( String org_id);
}

