package com.service;
import com.dao.ColumDao;
import com.pojo.Colum;
import java.util.List;
public class ColumService implements ColumInter{
    ColumDao columDao;
    public ColumDao getColumDao() {
        return columDao;
    }
    public void setColumDao(ColumDao columDao) {
        this.columDao = columDao;
    }
    @Override
    public List<Colum> getUserColum(String username) {
        return columDao.getUserColum(username);
    }
    @Override
    public int addColum(Colum colum) {
        if(countColum(colum.getUsername())!=0)
            colum.setColum_id(selectMaxColun(colum.getUsername())+1);
        return columDao.addColum(colum);
    }
    @Override
    public int selectMaxColun(String username) {
        return columDao.selectMaxColun(username);
    }
    @Override
    public int deleteColum(String username, int Columid) {
        return columDao.deleteColum(username,Columid);
    }
    @Override
    public Colum findColum(String username, int Columid) {
        return columDao.findColum(username,Columid);
    }
    @Override
    public int updateColum(Colum colum) {
        return columDao.updateColum(colum);
    }
    @Override
    public int countColum(String username) {
        return columDao.countColum(username);
    }
    @Override
    public String getColumName(String username, String m_username) {
        return columDao.getColumName(username,m_username);
    }
}
