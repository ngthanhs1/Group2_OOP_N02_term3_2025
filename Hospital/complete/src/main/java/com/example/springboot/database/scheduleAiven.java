package com.example.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.springboot.Model.Schedule;

public class scheduleAiven {

    public ArrayList<Schedule> getScheduleList() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnvencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM schedule");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                String id = rs.getString("id");
                String benhanId = rs.getString("benhanId");
                String patientId = rs.getString("patientId");
                String dateStr = rs.getString("date");
                String tenthuoc = rs.getString("tenthuoc");
                String soluong = rs.getString("soluong");

                Calendar date = Calendar.getInstance();
                try {
                    date.setTime(sdf.parse(dateStr));
                } catch (Exception e) {
                    date = null;
                }

                Schedule schedule = new Schedule(id, benhanId, patientId, date, tenthuoc, soluong);
                schedules.add(schedule);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
        return schedules;
    }
}
