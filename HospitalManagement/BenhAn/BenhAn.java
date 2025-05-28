package HospitalManagement.BenhAn;

import java.util.Calendar;

import HospitalManagement.CRUD.CoId;

public class BenhAn implements CoId{
    private String id;
    private String patientId;
    private Calendar ngayKham;
    private String trieuChung;
    private String tienSuBenh;
    private String chanDoan;

    public BenhAn(String id, String patientId, Calendar ngayKham,
                  String trieuChung, String tienSuBenh, String chanDoan) {
        this.id = id;
        this.patientId = patientId;
        this.ngayKham = ngayKham;
        this.trieuChung = trieuChung;
        this.tienSuBenh = tienSuBenh;
        this.chanDoan = chanDoan;
    }
    
    public String getId() {
        return id;
    }

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

    @Override
    public String toString() {
        return String.format("Mã bệnh án: %s | Mã bệnh nhân: %s | Ngày khám: %tF | Triệu chứng: %s | Tiền sử: %s | Chẩn đoán: %s",
                id, patientId, ngayKham, trieuChung, tienSuBenh, chanDoan);
    }
}
