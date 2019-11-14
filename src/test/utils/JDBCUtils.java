package test.utils;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by jsliang on 2019/11/14.
 */
public class JDBCUtils {
    private  static  final String driverClassName;
    private  static final String url;
    private  static  final  String username;
    private static  final String password;
    static {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("src/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClassName=properties.getProperty("driverClassName");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }
    public static void loadDriver(){
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection conn=null;
        try{
            loadDriver();
            conn= DriverManager.getConnection(url,username,password);

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void release(ResultSet rs, PreparedStatement pstmt,Connection conn ){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs=null;
            }
        }

        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                pstmt=null;
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                conn=null;
            }
        }

    }
}
