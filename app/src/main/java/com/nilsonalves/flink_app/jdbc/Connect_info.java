package com.nilsonalves.flink_app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_info {

    private final static String url = "jdbc:mysql://remotemysql.com:3306/ngz2OJ9ig1";
    private final static String user = "ngz2OJ9ig1";
    private final static String password = "Aj4bCKpQtm";

    public static Connection connection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
