package com.dao;
import com.pojo.FriendMessage;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface FriendMessageDao {
    int countNumber(@Param("username") String username,@Param("readed")  int readed);
    List<FriendMessage> getFriendMeList(@Param("username") String username, @Param("readed")  int readed);
    FriendMessage getFriendMessage(@Param("username") String username,@Param("m_username") String m_username,
                                   @Param("readed")  int readed, @Param("create_time") Date create_time);
    int okToFriend(FriendMessage friendMessage);
    int noToFriend(FriendMessage friendMessage);
    int submit_it(FriendMessage friendMessage);
    int readIt(@Param("username") String username, @Param("creat") Date creat, @Param("m_username") String m_username);
    int createFriendMessage(FriendMessage friendMessage);
    int deleteFriendMessage(@Param("username") String username, @Param("creat") Date creat, @Param("m_username") String m_username);
}
