package com.example.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.springboot.Model.BenhAn;

public class benhanAiven {

    public ArrayList<BenhAn> getBenhanList() {
        ArrayList<BenhAn> benhans = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmia33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM benhan");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                String id = rs.getString("id");
                String patientId = rs.getString("patientId");
                String ngayKhamStr = rs.getString("ngayKham");
                String trieuChung = rs.getString("trieuChung");
                String tienSuBenh = rs.getString("tienSuBenh");
                String chanDoan = rs.getString("chanDoan");
                String roomId = rs.getString("roomId");

                Calendar ngayKham = Calendar.getInstance();
                try {
                    ngayKham.setTime(sdf.parse(ngayKhamStr));
                } catch (Exception e) {
                    ngayKham = null;
                }

                BenhAn benhan = new BenhAn(id, patientId, ngayKham, trieuChung, tienSuBenh, chanDoan, roomId);
                benhans.add(benhan);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
        return benhans;
    }
}
