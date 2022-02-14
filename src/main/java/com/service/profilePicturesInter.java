package com.service;
import com.pojo.profilePictures;
import org.apache.ibatis.annotations.Param;
public interface profilePicturesInter {
    int createPicture(profilePictures pictures);
    String getPicture( String username);
    boolean isCreatePicture( String username);
    int updatePicture(profilePictures pictures);
}
