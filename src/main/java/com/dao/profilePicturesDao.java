package com.dao;
import com.pojo.profilePictures;
import org.apache.ibatis.annotations.Param;
public interface profilePicturesDao {
    int createPicture(profilePictures pictures);
    String getPicture(@Param("username") String username);
    int isCreatePicture(@Param("username") String username);
    int updatePicture(profilePictures pictures);
}
