package com.service;
import com.dao.profilePicturesDao;
import com.pojo.profilePictures;
import org.springframework.stereotype.Service;
@Service
public class profilePicturesService implements profilePicturesInter{
    private profilePicturesDao profilePicturesDao;
    public com.dao.profilePicturesDao getProfilePicturesDao() {
        return profilePicturesDao;
    }
    public void setProfilePicturesDao(com.dao.profilePicturesDao profilePicturesDao) {
        this.profilePicturesDao = profilePicturesDao;
    }
    @Override
    public int createPicture(profilePictures pictures) {
        return profilePicturesDao.createPicture(pictures);
    }
    @Override
    public String getPicture(String username) {
        return profilePicturesDao.getPicture(username);
    }
    @Override
    public boolean isCreatePicture(String username) {
        return (!(profilePicturesDao.isCreatePicture(username)==0));
    }
    @Override
    public int updatePicture(profilePictures pictures) {
        return profilePicturesDao.updatePicture(pictures);
    }
}
