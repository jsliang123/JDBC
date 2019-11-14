package test.demo2;

import test.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jsliang on 2019/11/14.
 */
public class login {
    public static void user_login(String username,String password){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        conn= JDBCUtils.getConnection();
        String sql="select * from test_table where username=? and password=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            if(rs.next()){
                System.out.println("登陆成功");
            }
            else {
                System.out.println("登陆失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }

    }
}
