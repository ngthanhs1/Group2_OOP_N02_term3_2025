package HospitalManagement.Test;

import HospitalManagement.Prescription.Prescription;
import HospitalManagement.Medicine.Medicine;

import java.util.Scanner;

public class TestQuayThuoc {
    private Prescription prescription;

    public TestQuayThuoc(TestPrescription tp) {
        this.prescription = tp.getPrescription(); 
    }

    public void inThuocTrongDon() {
        System.out.println("== Danh sách thuốc trong đơn ==");
        for (Medicine m : prescription.getDanhSachThuoc()) {
            System.out.println(m);
        }
    }

    public void timKiemTheoTen() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên thuốc cần tìm: ");
        String tenCanTim = sc.nextLine().toLowerCase();

        boolean timThay = false;
        System.out.println("== Kết quả tìm kiếm ==");
        for (Medicine m : prescription.getDanhSachThuoc()) {
            if (m.getTenThuoc().toLowerCase().contains(tenCanTim)) {
                System.out.println(m);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy thuốc có tên chứa \"" + tenCanTim + "\".");
        }
    }
}
