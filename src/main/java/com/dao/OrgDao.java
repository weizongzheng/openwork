package com.dao;
import com.pojo.Org;
import org.apache.ibatis.annotations.Param;
import java.util.*;
public interface OrgDao {
    String getOrgName(@Param("org_id") String org_id);
    String getCreateOrgUsername(@Param("org_id") String org_id);
    Org getOrg(@Param("org_id") String org_id);
    int orgIsExit(@Param("org_id") String org_id);
    int intoOrg(@Param("org_id") String org_id);
    int exitOrg(@Param("org_id") String org_id);
    int createOrg(Org org);
    List<Org> getUserAllOrg(@Param("username") String username);
    int updateContent(@Param("org_id") String org_id,@Param("content") String content);
    int updateName(@Param("org_id") String org_id,@Param("name") String name);
    int deleteOrg(@Param("org_id") String org_id);
}