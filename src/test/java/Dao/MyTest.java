package Dao;

import com.service.LoginService;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    @Test
    public void logindaoTest(){
        String t="2019-01-02";
        Date d=new Date();
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleFormat.format(d));
    }
}
