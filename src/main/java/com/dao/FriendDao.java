package com.dao;
import com.pojo.Friend;
import com.pojo.FriendMessage;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface FriendDao {
    int friendNumber(@Param("username") String username );
    List<Friend> getColumFriends(@Param("username") String username,@Param("colum") int columid);
    int isFriend(@Param("m_username") String m_username,@Param("username") String username);
    Friend getfriendinf(@Param("m_username") String m_username,@Param("username") String username);
    int addFriends(FriendMessage friendMessage);
    List<Friend> getAllFriends(@Param("username") String username);
    int updateUserColum(@Param("m_username") String m_username,@Param("username") String username,@Param("colum") int columid);
    int deleteFriend(@Param("m_username") String m_username,@Param("username") String username);
}
