package com.example.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import com.example.springboot.Model.Patient;

public class patientAiven {

    public ArrayList<Patient> getPatientList() {
        ArrayList<Patient> patients = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_mCYm4qgQ7vdJ-vfVtGb@mysql-2073b098-hospitalll.b.aivencloud.com:16089/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id, name, dob, gender, address, phone FROM patient");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                java.sql.Date dobSql = rs.getDate("dob");
                Calendar dob = Calendar.getInstance();
                if (dobSql != null) {
                    dob.setTime(dobSql);
                }
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Patient patient = new Patient(id, name, dob, gender, address, phone);
                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        return patients;
    }
}
