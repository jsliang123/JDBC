package test.demo1;

import test.demo2.login;
import test.utils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jsliang on 2019/11/14.
 */
public class demo1_1 {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    @Test
    public void demo1(){
        login.user_login("xiaoming","234");

    }
}
