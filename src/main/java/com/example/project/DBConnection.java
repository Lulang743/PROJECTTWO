package com.example.project;

import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBConnection {
        public java.sql.Connection connect_to_db(String dbname, String user, String pass) {
            java.sql.Connection conn = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
                if (conn!=null){
                    System.out.println("CONNECTION ESTABLISHED");

                }
                else {
                    System.out.println("CONNECTION not ESTABLISHED");
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

            return conn;
        }

}
