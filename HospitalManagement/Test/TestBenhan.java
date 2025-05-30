package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestBenhan {
    private ListChung<BenhAn> dsBenhan = new ListChung<>();
    private ListChung<Patient> dsPatient;

    public TestBenhan(TestPatient testPatient) {
        this.dsPatient = testPatient.getPatientList();
    }

    public void themBenhAn() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh án cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\n=== Nhập thông tin bệnh án thứ " + (i + 1) + " ===");

            System.out.print("Mã bệnh án: ");
            String id = sc.nextLine();

            if (dsBenhan.timKiem(id) != null) {
                System.out.println("Mã bệnh án đã tồn tại. Vui lòng nhập mã khác.");
                i--;
                continue;
            }

            System.out.print("Mã bệnh nhân: ");
            String patientId = sc.nextLine();

            Patient p = dsPatient.timKiem(patientId);
            if (p == null) {
                System.out.println("Không tìm thấy bệnh nhân có mã: " + patientId);
                i--;
                continue;
            }

            Calendar ngayKham = null;
            while (ngayKham == null) {
                try {
                    System.out.print("Ngày khám (dd/MM/yyyy): ");
                    Date date = sdf.parse(sc.nextLine().trim());
                    ngayKham = Calendar.getInstance();
                    ngayKham.setTime(date);
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
                }
            }

            System.out.print("Triệu chứng: ");
            String trieuChung = sc.nextLine();

            System.out.print("Tiền sử bệnh: ");
            String tienSuBenh = sc.nextLine();

            System.out.print("Chẩn đoán: ");
            String chanDoan = sc.nextLine();

            BenhAn ba = new BenhAn(id, patientId, ngayKham, trieuChung, tienSuBenh, chanDoan);
            dsBenhan.them(ba);
        }
    }

    public void inBenhAn() {
        dsBenhan.inDanhSach();
    }

    public void xoaBenhAn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã bệnh án cần xoá: ");
        String id = sc.nextLine();

        BenhAn old = dsBenhan.timKiem(id);
        if (old == null) {
            System.out.println("Không tìm thấy bệnh án.");
        } else {
            dsBenhan.xoa(id);
            System.out.println("Đã xoá thành công. Danh sách hiện tại:");
            dsBenhan.inDanhSach();
        }
    }

    public void suaBenhAn() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập mã bệnh án cần sửa: ");
        String id = sc.nextLine();

        BenhAn old = dsBenhan.timKiem(id);
        if (old == null) {
            System.out.println("Không tìm thấy bệnh án.");
            return;
        }

        System.out.println("\nĐang sửa thông tin cho bệnh án mã: " + id);

        Calendar ngayKham = null;
        while (ngayKham == null) {
            try {
                System.out.print("Ngày khám mới (dd/MM/yyyy): ");
                Date date = sdf.parse(sc.nextLine().trim());
                ngayKham = Calendar.getInstance();
                ngayKham.setTime(date);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }

        System.out.print("Triệu chứng mới: ");
        String trieuChung = sc.nextLine();

        System.out.print("Tiền sử bệnh mới: ");
        String tienSuBenh = sc.nextLine();

        System.out.print("Chẩn đoán mới: ");
        String chanDoan = sc.nextLine();

        BenhAn newBA = new BenhAn(id, old.getPatientId(), ngayKham, trieuChung, tienSuBenh, chanDoan);
        dsBenhan.sua(id, newBA);

        System.out.println("\nDanh sách bệnh án sau khi sửa:");
        dsBenhan.inDanhSach();
    }

    public ListChung<BenhAn> getDsBenhan() {
        return dsBenhan;
    }
}
