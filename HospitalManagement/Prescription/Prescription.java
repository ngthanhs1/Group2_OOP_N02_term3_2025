package HospitalManagement.Prescription;

import HospitalManagement.CRUD.CoId;
import HospitalManagement.Medicine.Medicine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Prescription implements CoId {
    private String id;
    private String patientId;
    private List<Medicine> danhSachThuoc;
    private Calendar ngayCap;

    // Constructor đầy đủ
    public Prescription(String id, String patientId, List<Medicine> danhSachThuoc, Calendar ngayCap) {
        this.id = id;
        this.patientId = patientId;
        this.danhSachThuoc = danhSachThuoc != null ? danhSachThuoc : new ArrayList<>();
        this.ngayCap = ngayCap;
    }

    // Constructor mặc định (phục vụ TestPrescription)
    public Prescription() {
        this.id = "P" + System.currentTimeMillis(); // tự tạo ID đơn thuốc
        this.patientId = "";
        this.danhSachThuoc = new ArrayList<>();
        this.ngayCap = Calendar.getInstance();
    }

    // Thêm thuốc vào danh sách
    public void themThuoc(Medicine m) {
        if (m != null) {
            danhSachThuoc.add(m);
        }
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

    public List<Medicine> getDanhSachThuoc() {
        return danhSachThuoc;
    }

    public void setDanhSachThuoc(List<Medicine> danhSachThuoc) {
        this.danhSachThuoc = danhSachThuoc;
    }

    public Calendar getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Calendar ngayCap) {
        this.ngayCap = ngayCap;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Mã đơn: %-6s | Mã BN: %-6s | Ngày cấp: %s\n", id, patientId, sdf.format(ngayCap.getTime())));
        sb.append("Danh sách thuốc:\n");
        for (Medicine m : danhSachThuoc) {
            sb.append(" - ").append(m.toString()).append("\n");
        }
        return sb.toString();
    }
}
