package com.dao;
import com.pojo.Colum;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ColumDao {
    List<Colum> getUserColum(@Param("username") String username);
    int addColum(Colum colum);
    int selectMaxColun(@Param("username") String username);
    int deleteColum(@Param("username") String username,@Param("columid") int Columid);
    Colum findColum(@Param("username") String username,@Param("columid") int Columid);
    int updateColum(Colum colum);
    int countColum(@Param("username") String username);
    String getColumName(@Param("username") String username,@Param("m_username") String m_username);
}
