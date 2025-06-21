package com.example.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.springboot.Model.Room;

public class roomAiven {

    public ArrayList<Room> getRoomList() {
        ArrayList<Room> rooms = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_mCYm4qgQ7vdJ-vfVtGb@mysql-2073b098-hospitalll.b.aivencloud.com:16089/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM room");

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String doctorName = rs.getString("doctorName");

                Room room = new Room(id, name, doctorName);
                rooms.add(room);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
        return rooms;
    }
}
