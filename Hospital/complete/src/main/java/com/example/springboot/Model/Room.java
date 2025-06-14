package com.example.springboot.Model;

import com.example.springboot.CRUD.CoId;

public class Room implements CoId {
    private String id;
    private String name;
    private String doctorName;

    public Room(String id, String name, String doctorName) {
        this.id = id;
        this.name = name;
        this.doctorName = doctorName;
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

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    @Override
    public String toString() {
        return String.format(
            "Mã phòng: %s | Tên phòng: %s\nBác sĩ phụ trách: %s ",
            id, name, doctorName);
    }
}
