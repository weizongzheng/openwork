package com.service;
import com.pojo.Colum;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface ColumInter {
    List<Colum> getUserColum( String username);
    int addColum(Colum colum);
    int selectMaxColun( String username);
    int deleteColum( String username, int Columid);
    Colum findColum(String username,int Columid);
    int updateColum(Colum colum);
    int countColum(String username);
    String getColumName( String username, String m_username);
}
