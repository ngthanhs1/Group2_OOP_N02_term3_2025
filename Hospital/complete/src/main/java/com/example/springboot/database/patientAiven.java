package com.example.springboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.example.springboot.Model.Patient;

public class patientAiven {

    public ArrayList<Patient> getPatientList() {
        ArrayList<Patient> patients = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://avnad-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED",
                "sqluser", "password"
            );
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM patient");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String dobStr = rs.getString("dob");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                Calendar dob = Calendar.getInstance();
                try {
                    dob.setTime(sdf.parse(dobStr));
                } catch (Exception e) {
                    dob = null;
                }

                Patient patient = new Patient(id, name, dob, gender, address, phone);
                patients.add(patient);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error in database connection");
            e.printStackTrace();
        }
        return patients;
    }
}
