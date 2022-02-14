package com.dao;
import com.pojo.IntoOrg;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface IntoOrgDao {
    List<IntoOrg> getOrgList(@Param("username") String username,@Param("begin") int begin,@Param("end") int end);
    int intoNumber(@Param("username") String username);
    List<IntoOrg> getInto_User_List(@Param("org_id") String org_id);
    int intoOrg(@Param("org_id") String org_id,@Param("username") String username);
    int exitOrg(@Param("org_id") String org_id,@Param("username") String username);
    int isIntoOrg(@Param("org_id") String org_id,@Param("username") String username);
    int ListintoOrg(@Param("org_id") String org_id,@Param("usernames") List<String> usernames);
    int mandatoryDeleteUser(@Param("org_id") String org_id,@Param("username") String username);
    int deleteOrg(@Param("org_id") String org_id);
    List<IntoOrg> getUserAllOrg(@Param("username") String username);
    int getOrg_UserNumber(@Param("org_id") String org_id);
}
