package com.example.springboot.Model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.example.springboot.CRUD.CoId;

public class Patient implements CoId {
    private String id;
    private String name;
    private Calendar dob;
    private int age;
    private String gender;
    private String address;
    private String phone;

    public Patient(String id, String name, Calendar dob, String gender, String address, String phone) {
        this.id = id;
        this.name = name;
        setDob(dob);
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
        this.age = calculateAge(dob);
    }

    public int getAge() {
        return age;
    }

    private int calculateAge(Calendar dob) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < dob.get(Calendar.MONTH) || 
            (now.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && now.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            year--;
        }
        return year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dobStr = (dob != null) ? sdf.format(dob.getTime()) : "N/A";
        return String.format("%-10s | %-18s | %-12s | %-3d | %-6s | %-12s | %-10s",
                id, name, dobStr, age, gender, address, phone);
    }
}
