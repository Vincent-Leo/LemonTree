package com.vincent.sqoop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class SqoopSqlServer {

    public static Connection conn = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    public static BufferedWriter writer;


    public static void generateSqoopShellCmd(String source) throws Exception {
        writer = new BufferedWriter(new FileWriter(new File("E://" + source + ".sh")));
        String sqlserverTbName = null;
        String sql = "select tbName from " + source + " group by tbName";
        conn = getConnectionSqlServer();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);

        writer.write("#!/bin/bash");
        writer.newLine();
        while (rs.next()) {
            sqlserverTbName = rs.getString(1);
            String str = String.valueOf(new Date().getTime()) + sqlserverTbName;
            String hiveTbName = "db100." + md5encode32(str);
            String sqoopShell = "sqoop import --connect 'jdbc:sqlserver://120.55.86.190;username=sa;password=dream613;database=guoyun_mid'"
                    + " --table " + sqlserverTbName
                    + " --hive-table " + hiveTbName
                    + " --hive-import "
                    + " -m 1;";
            writer.write("eval \"" + sqoopShell + "\"");
            writer.newLine();
            writer.flush();

            String insertSQL = "insert into sqoop values('" + sqlserverTbName + "','" + hiveTbName + "');";
            insertIntoSqlserver(insertSQL);
        }
        writer.close();
    }


    public static String md5encode32(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {

        } catch (Exception e) {

        }
        return result;
    }

    public static Connection getConnectionSqlServer() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://120.55.86.190:1433;databasename=guoyun_mid";
        String userName = "sa";
        String userPwd = "dream613";

        Connection dbConn = null;
        try {
            Class.forName(driverName).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            return dbConn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insertIntoSqlserver(String sql) throws Exception {
        conn = getConnectionSqlServer();
        stmt = conn.createStatement();
        stmt.execute(sql);
    }


    public static void main(String[] args) throws Exception {
        generateSqoopShellCmd("bigtb_city_year_info");
        generateSqoopShellCmd("bigtb_province_month_info");
        generateSqoopShellCmd("bigtb_province_quarter_info");
        generateSqoopShellCmd("bigtb_province_year_info");

    }

}
