package com.nilsonalves.flink_app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_Remot {

//    private final static String url = "jdbc:mysql://192.168.100.3/icode_store";
    private final static String url = "jdbc:mysql://10.0.2.2:3306/icode_store"; //Acessar pelo Emulador
    private final static String user = "root";
    private final static String password = "";

    public static Connection connection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão Bem sucedida");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
