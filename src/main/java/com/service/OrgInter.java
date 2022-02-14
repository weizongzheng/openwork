package com.service;
import com.pojo.Org;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface OrgInter {
    String getOrgName(String org_id);
    String getCreateOrgUsername(String org_id);
    Org getOrg( String org_id);
    boolean orgIsExit( String org_id);
    int intoOrg( String org_id);
    int exitOrg( String org_id);
    int createOrg(Org org);
    List<Org> getUserAllOrg(String username);
    int updateContent(String org_id,String content);
    int updateName( String org_id, String name);
    int deleteOrg( String org_id);
}
