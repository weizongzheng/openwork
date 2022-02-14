package com.service;
import com.pojo.Friend;
import com.pojo.FriendMessage;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface FriendInter {
    int friendNumber( String username );
    List<Friend> getColumFriends( String username,int columid);
    int isFriend( String m_username, String username);
    Friend getfriendinf( String m_username,String username);
    int addFriends(FriendMessage friendMessage);
    List<Friend> getAllFriends(String username);
    int updateUserColum( String m_username, String username, int columid);
    int deleteFriend(String m_username, String username);
}
