package HospitalManagement.BenhAn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import HospitalManagement.CRUD.CoId;
import HospitalManagement.CRUD.LinkBenhAn;
import HospitalManagement.Room.Doctor;

public class BenhAn implements CoId, LinkBenhAn {
    private String id;
    private String patientId;
    private Calendar ngayKham;
    private String trieuChung;
    private String tienSuBenh;
    private String chanDoan;
    private String doctorId;
    private String roomId;

    private static List<Doctor> doctorList;

    public BenhAn(String id, String patientId, Calendar ngayKham,
                  String trieuChung, String tienSuBenh, String chanDoan,
                  String doctorId, String roomId) {
        this.id = id;
        this.patientId = patientId;
        this.ngayKham = ngayKham;
        this.trieuChung = trieuChung;
        this.tienSuBenh = tienSuBenh;
        this.chanDoan = chanDoan;
        this.doctorId = doctorId;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public static void setDoctorList(List<Doctor> list) {
        doctorList = list;
    }

    public static List<Doctor> getDoctorList() {
        return doctorList;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format(
            "Mã BA: %s | Mã BN: %s | Ngày khám: %s | Triệu chứng: %s | Tiền sử bệnh: %s | Chẩn đoán: %s | Mã bác sĩ: %s | Mã phòng: %s",
            id, patientId, sdf.format(ngayKham.getTime()), trieuChung, tienSuBenh, chanDoan, doctorId, roomId
        );
    }
}
