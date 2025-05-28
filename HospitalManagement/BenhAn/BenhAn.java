package HospitalManagement.BenhAn;

import HospitalManagement.Patientt.Patient;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BenhAn {
    private String id;            
    private Patient patient;
    private Calendar ngayLap;
    private String trieuChung;
    private String tienSuBenh;
    private String chanDoan;

    public BenhAn(String id, Patient patient, Calendar ngayLap, String trieuChung, String tienSuBenh, String chanDoan) {
        this.id = id;
        this.patient = patient;
        this.ngayLap = ngayLap;
        this.trieuChung = trieuChung;
        this.tienSuBenh = tienSuBenh;
        this.chanDoan = chanDoan;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Calendar getNgayLap() {
        return ngayLap;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public String getTienSuBenh() {
        return tienSuBenh;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return  "----- BỆNH ÁN -----\n" +
                "Mã bệnh án: " + id + "\n" +
                "Ngày lập: " + sdf.format(ngayLap.getTime()) + "\n" +
                "Triệu chứng: " + trieuChung + "\n" +
                "Tiền sử bệnh: " + tienSuBenh + "\n" +
                "Chẩn đoán: " + chanDoan + "\n" +
                patient.toString() +
                "-------------------\n";
    }
}
