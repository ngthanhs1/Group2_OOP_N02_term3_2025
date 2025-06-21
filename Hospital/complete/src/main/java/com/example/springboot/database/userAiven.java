package com.example.springboot.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.springboot.Model.User;

public class userAiven {

    public ArrayList<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_mCYm4qgQ7vdJ-vfVtGb@mysql-2073b098-hospitalll.b.aivencloud.com:16089/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(username, password, null);
                users.add(user);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
        return users;
    }
}