package com.service;
import com.dao.FriendMessageDao;
import com.pojo.FriendMessage;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
@Service
public class FriendMessageService implements FriendMessageInter{
    FriendMessageDao friendMessageDao;
    public FriendMessageDao getFriendMessageDao() {
        return friendMessageDao;
    }
    public void setFriendMessageDao(FriendMessageDao friendMessageDao) {
        this.friendMessageDao = friendMessageDao;
    }
    @Override
    public int countNumber(String username, int readed) {
        return friendMessageDao.countNumber(username,readed);
    }
    @Override
    public List<FriendMessage> getFriendMeList(String username, int readed) {
        return friendMessageDao.getFriendMeList(username,readed);
    }
    @Override
    public FriendMessage getFriendMessage(String username, String m_username, Date create_time, int readed) {
        return friendMessageDao.getFriendMessage(username,m_username,readed,create_time);
    }
    @Override
    public int okToFriend(FriendMessage friendMessage) {
        return friendMessageDao.okToFriend(friendMessage);
    }
    @Override
    public int readIt(String username, Date creat, String m_username) {
        return friendMessageDao.readIt(username,creat,m_username);
    }
    @Override
    public int submit_it(FriendMessage friendMessage) {
        return friendMessageDao.submit_it(friendMessage);
    }
    @Override
    public int noToFriend(FriendMessage friendMessage) {
        return friendMessageDao.noToFriend(friendMessage);
    }
    @Override
    public int createFriendMessage(FriendMessage friendMessage) {
        return friendMessageDao.createFriendMessage(friendMessage);
    }
    @Override
    public int deleteFriendMessage(String username, Date creat, String m_username) {
        return friendMessageDao.deleteFriendMessage(username,creat,m_username);
    }
}
