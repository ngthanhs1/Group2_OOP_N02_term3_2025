package HospitalManagement.Test;

import HospitalManagement.Schedule.Schedule;
import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.Patientt.Patient;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.ChucNang.LichCapThuoc;
import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestSchedule {
    private ListChung<Schedule> dsSchedule = new ListChung<>();
    private ListChung<Patient> dsPatient = new ListChung<>();
    private ListChung<BenhAn> dsBenhan = new ListChung<>();

    public TestSchedule(TestPatient testPatient, TestBenhan testBenhan) {
        this.dsPatient = testPatient.getPatientList();
        this.dsBenhan = testBenhan.getBenhanList();
    }

    public void themSchedule() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng lịch cấp thuốc cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n;) {
            System.out.println("\n_Nhập thông tin lịch cấp thuốc thứ " + (i + 1) + ":");

            System.out.print("Mã schedule: ");
            String id = sc.nextLine();
            if (dsSchedule.timKiem(id) != null) {
                System.out.println("Mã schedule đã tồn tại. Vui lòng nhập mã khác.");
                continue;
            }

            System.out.print("Mã bệnh án: ");
            String benhanId = sc.nextLine();
            BenhAn benhAn = dsBenhan.timKiem(benhanId);
            if (benhAn == null) {
                System.out.println("Không tìm thấy bệnh án có mã: " + benhanId);
                continue;
            }

            String patientId = benhAn.getPatientId();
            System.out.println("→ Mã bệnh nhân: " + patientId);

            Calendar date = null;
            while (date == null) {
                try {
                    System.out.print("Ngày cấp thuốc (dd/MM/yyyy): ");
                    Date d = sdf.parse(sc.nextLine().trim());
                    date = Calendar.getInstance();
                    date.setTime(d);
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
                }
            }

            System.out.print("Tên thuốc: ");
            String tenthuoc = sc.nextLine();

            System.out.print("Số lượng: ");
            String soluong = sc.nextLine();

            Schedule s = new Schedule(id, benhanId, patientId, date, tenthuoc, soluong);
            dsSchedule.them(s);
            System.out.println("→ Đã thêm lịch cấp thuốc thành công!");
            i++;
        }
    }

    public void inSchedule() {
        System.out.println("\n--- Danh sách lịch cấp thuốc ---");
        System.out.printf("%-8s | %-8s | %-8s | %-15s | %-10s | %-13s\n",
                "Mã BT", "Mã BA", "Mã BN", "Ngày cấp", "Tên thuốc", "Số lượng(viên)");
        System.out.println("-----------------------------------------------------------------------------------");
        dsSchedule.inDanhSach();
    }
    public void xoaSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã schedule cần xoá: ");
        String id = sc.nextLine();

        Schedule s = dsSchedule.timKiem(id);
        if (s == null) {
            System.out.println("Không tìm thấy lịch cấp thuốc.");
        } else {
            dsSchedule.xoa(id);
            System.out.println("→ Đã xoá thành công. Danh sách hiện tại:");
            dsSchedule.inDanhSach();
        }
    }
    public void suaSchedule() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập mã schedule cần sửa: ");
        String id = sc.nextLine();

        Schedule old = dsSchedule.timKiem(id);
        if (old == null) {
            System.out.println("Không tìm thấy schedule.");
            return;
        }

        System.out.println("\n=== Đang sửa thông tin cho schedule mã: " + id + " ===");

        Calendar date = null;
        while (date == null) {
            try {
                System.out.print("Ngày cấp thuốc mới (dd/MM/yyyy): ");
                Date d = sdf.parse(sc.nextLine().trim());
                date = Calendar.getInstance();
                date.setTime(d);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }

        System.out.print("Tên thuốc mới: ");
        String tenthuoc = sc.nextLine();

        System.out.print("Số lượng mới: ");
        String soluong = sc.nextLine();

        Schedule newS = new Schedule(id, old.getBenhanId(), old.getPatientId(), date, tenthuoc, soluong);
        dsSchedule.sua(id, newS);

        System.out.println("→ Đã cập nhật thành công. Danh sách sau khi sửa:");
        dsSchedule.inDanhSach();
    }

    public ListChung<Schedule> getDsSchedule() {
        return dsSchedule;
    }
    public void inCapThuocTrongNgay() {
    LichCapThuoc inTheoNgay = new LichCapThuoc(dsSchedule);
    inTheoNgay.inTheoNgay();
}

}
