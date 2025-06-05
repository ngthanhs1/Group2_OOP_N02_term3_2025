package HospitalManagement.Test;

import HospitalManagement.QuayThuoc.QuayThuoc;
import HospitalManagement.CRUD.ListChung;

public class TestQuayThuoc {
    private ListChung<QuayThuoc> danhSachQuay = new ListChung<>();

    public void dsMauQuayThuoc() {
        danhSachQuay.them(new QuayThuoc("QT01", "Quầy A", "Tầng 1"));
        danhSachQuay.them(new QuayThuoc("QT02", "Quầy B", "Tầng 2"));
        danhSachQuay.them(new QuayThuoc("QT03", "Quầy C", "Tầng 3"));
    }

    public ListChung<QuayThuoc> getDanhSachQuay() {
        return danhSachQuay;
    }

    public void inDanhSachQuay() {
        System.out.println("\n=== DANH SÁCH QUẦY THUỐC ===");
        System.out.printf("%-5s | %-10s | %-10s\n", "ID", "Tên quầy", "Vị trí");
        System.out.println("--------------------------------------");
        for (QuayThuoc q : danhSachQuay.getList()) {
            System.out.println(q);
        }
    }
}
