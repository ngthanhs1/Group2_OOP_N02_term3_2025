package HospitalManagement.Test;

import HospitalManagement.Medicine.Medicine;
import HospitalManagement.CRUD.ListChung;

public class TestMedicine {
    private ListChung<Medicine> danhSachThuoc = new ListChung<>();

    public void dsMauThuoc() {
        danhSachThuoc.them(new Medicine("Paracetamol", "500mg", 3, "Giảm đau, hạ sốt"));
        danhSachThuoc.them(new Medicine("Vitamin C", "1000mg", 1, "Tăng sức đề kháng"));
        danhSachThuoc.them(new Medicine("Amoxicillin", "250mg", 2, "Kháng sinh"));
    }

    public ListChung<Medicine> getDanhSachThuoc() {
        return danhSachThuoc;
    }

    public void inDanhSachThuoc() {
        System.out.println("\n=== DANH SÁCH THUỐC MẪU ===");
        System.out.printf("%-15s | %-7s | %-10s | %s\n", "Tên thuốc", "Liều", "Lần/ngày", "Ghi chú");
        System.out.println("-----------------------------------------------------------");
        for (Medicine m : danhSachThuoc.getList()) {
            System.out.println(m);
        }
    }
}
