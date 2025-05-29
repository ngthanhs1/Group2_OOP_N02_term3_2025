package HospitalManagement.Patientt;

import java.util.Calendar;

import HospitalManagement.CRUD.CoId;

import java.text.SimpleDateFormat;

public class Patient implements CoId{
    private String id;
    private String name;
    private Calendar dob;
    private String gender;
    private String address;
    private String phone;
    private String medicalHistory;

    
    public Patient(String id, String name, Calendar dob, String gender, String address, String phone,
            String medicalHistory) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.medicalHistory = medicalHistory;
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

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return String.format("%-10s | %-20s | %-12s | %-6s | %-15s | %-11s | %-20s",id,name,sdf.format(dob.getTime()),gender,address,phone,medicalHistory);
    }


}
