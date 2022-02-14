package com.dao;
import com.pojo.FriendMessage;
import com.pojo.OrgMessage;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface OrgMessageDao {
    int countNumber(@Param("username") String username, @Param("readed")  int readed);
    List<OrgMessage> getOrgMeList(@Param("username") String username, @Param("readed")  int readed);
    int readIt(@Param("username") String username, @Param("creat") Date creat, @Param("org_id") String org_id);
    OrgMessage getOrgMessage(@Param("username") String username,@Param("org_id") String org_id,
                                   @Param("readed")  int readed, @Param("create_time") Date create_time);
    int deleteOrgMessage(@Param("username") String username, @Param("creat") Date creat, @Param("org_id") String org_id);
    int createOrgMessage(OrgMessage orgMessage);
    int deleteOrgAllMessage(@Param("org_id") String org_id);
}
