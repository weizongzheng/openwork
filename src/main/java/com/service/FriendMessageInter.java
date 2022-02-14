package com.service;
import com.pojo.FriendMessage;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;
public interface FriendMessageInter {
    int countNumber(String username, int readed);
    List<FriendMessage> getFriendMeList( String username,int readed);
    FriendMessage getFriendMessage(String username,String m_username,Date create_time, int readed);
    int okToFriend(FriendMessage friendMessage);
    int readIt(String username, Date creat, String m_username);
    int submit_it(FriendMessage friendMessage);
    int noToFriend(FriendMessage friendMessage);
    int createFriendMessage(FriendMessage friendMessage);
    int deleteFriendMessage(String username, Date creat,  String m_username);
}
