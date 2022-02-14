package com.service;
import com.dao.FriendDao;
import com.pojo.Friend;
import com.pojo.FriendMessage;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FriendService implements FriendInter{
    FriendDao friendDao;
    public FriendDao getFriendDao() {
        return friendDao;
    }
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }
    @Override
    public int friendNumber(String username) {
        return friendDao.friendNumber(username);
    }
    @Override
    public List<Friend> getColumFriends(String username, int columid) {
        return friendDao.getColumFriends(username,columid);
    }
    @Override
    public int isFriend(String m_username, String username) {
        return friendDao.isFriend(m_username,username);
    }
    @Override
    public Friend getfriendinf(String m_username, String username) {
        return friendDao.getfriendinf(m_username,username);
    }
    @Override
    public int addFriends(FriendMessage friendMessage) {
        return friendDao.addFriends(friendMessage);
    }
    @Override
    public List<Friend> getAllFriends(String username) {
        return friendDao.getAllFriends(username);
    }
    @Override
    public int updateUserColum(String m_username, String username, int columid) {
        return friendDao.updateUserColum(m_username,username,columid);
    }
    @Override
    public int deleteFriend(String m_username, String username) {
        friendDao.deleteFriend(m_username,username);
        friendDao.deleteFriend(username,m_username);
        return 1;
    }
}
