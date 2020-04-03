package com.nilsonalves.flink_app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_info {

    private final static String url = "jdbc:mysql://remotemysql.com:3306/LsNEUoch4h";
    private final static String user = "LsNEUoch4h";
    private final static String password = "e7R8ahT7GR";

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
