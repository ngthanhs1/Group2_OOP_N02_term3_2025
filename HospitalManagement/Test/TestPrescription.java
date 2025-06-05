package HospitalManagement.Test;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Prescription.Prescription;
import HospitalManagement.Medicine.Medicine;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestPrescription {
    private ListChung<Prescription> danhSachDonThuoc = new ListChung<>();
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private final TestMedicine testMedicine = new TestMedicine();
    private final TestPatient testPatient = new TestPatient();

    public TestPrescription() {
        testMedicine.dsMauThuoc();
        testPatient.dsMauPatient();
    }

    public void themDonThuoc() {
        System.out.print("Nhập số đơn thuốc cần thêm: ");
        int soLuong;
        try {
            soLuong = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Số không hợp lệ.");
            return;
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Nhập đơn thuốc thứ " + (i + 1) + " ---");
            System.out.print("Nhập mã đơn thuốc: ");
            String id = sc.nextLine().trim();
            if (danhSachDonThuoc.timKiem(id) != null) {
                System.out.println("ID đã tồn tại.");
                continue;
            }

            System.out.print("Nhập mã bệnh nhân: ");
            String patientId = sc.nextLine().trim();
            if (testPatient.getPatientList().timKiem(patientId) == null) {
                System.out.println("Không tìm thấy bệnh nhân.");
                continue;
            }

            System.out.print("Nhập ngày cấp (dd/MM/yyyy): ");
            Calendar ngayCap = Calendar.getInstance();
            try {
                Date date = sdf.parse(sc.nextLine().trim());
                ngayCap.setTime(date);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ.");
                continue;
            }

            System.out.println("Chọn thuốc cho đơn (chọn theo ID, nhập 'x' để dừng):");
            testMedicine.inDanhSachThuoc();
            List<Medicine> thuocChon = new ArrayList<>();
            while (true) {
                System.out.print("Nhập tên thuốc: ");
                String tenThuoc = sc.nextLine().trim();
                if (tenThuoc.equalsIgnoreCase("x")) break;

                Medicine m = null;
                for (Medicine item : testMedicine.getDanhSachThuoc().getList()) {
                    if (item.getTenThuoc().equalsIgnoreCase(tenThuoc)) {
                        m = item;
                        break;
                    }
                }

                if (m != null) {
                    thuocChon.add(m);
                    System.out.println("Đã thêm: " + m.getTenThuoc());
                } else {
                    System.out.println("Không tìm thấy thuốc.");
                }
            }

            if (thuocChon.isEmpty()) {
                System.out.println("Không có thuốc nào được chọn.");
                continue;
            }

            Prescription pres = new Prescription(id, patientId, thuocChon, ngayCap);
            danhSachDonThuoc.them(pres);
        }
    }

    public void inDonThuoc() {
        System.out.println("\n=== DANH SÁCH ĐƠN THUỐC ===");
        if (danhSachDonThuoc.getList().isEmpty()) {
            System.out.println("Không có đơn thuốc nào.");
            return;
        }
        for (Prescription p : danhSachDonThuoc.getList()) {
            System.out.println(p);
        }
    }

    public ListChung<Prescription> getDanhSachDonThuoc() {
        return danhSachDonThuoc;
    }
}
