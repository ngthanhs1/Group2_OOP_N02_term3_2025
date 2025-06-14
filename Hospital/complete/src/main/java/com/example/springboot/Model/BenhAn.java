
package com.example.springboot.Model;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.example.springboot.CRUD.CoId;

public class BenhAn implements CoId{
    private String id;
    private String patientId;
    private Calendar ngayKham;
    private String trieuChung;
    private String tienSuBenh;
    private String chanDoan;
    private String roomId;

    public BenhAn(String id, String patientId, Calendar ngayKham,String trieuChung, String tienSuBenh, String chanDoan, String roomId) {
        this.id = id;
        this.patientId = patientId;
        this.ngayKham = ngayKham;
        this.trieuChung = trieuChung;
        this.tienSuBenh = tienSuBenh;
        this.chanDoan = chanDoan;
        this.roomId = roomId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Calendar getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Calendar ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getTienSuBenh() {
        return tienSuBenh;
    }

    public void setTienSuBenh(String tienSuBenh) {
        this.tienSuBenh = tienSuBenh;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-5s | %-5s | %-5s | %-18s | %-12s | %-12s | %-12s | %-12s",id,patientId,roomId,sdf.format(ngayKham.getTime()),trieuChung,tienSuBenh,chanDoan);
    }

}
