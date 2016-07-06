package com.vincent.db;

import com.vincent.dao.Stock;

import java.sql.*;
import java.util.List;

public class MySQL {

    private static Connection conn;

    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://121.41.76.135:3306/test";
        String user = "dreambox";
        String pwd = "dream613";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet execQuery(String sql) {
        if (conn == null) {
            conn = getConnection();
        }
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
