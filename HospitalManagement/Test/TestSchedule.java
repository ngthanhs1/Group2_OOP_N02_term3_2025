package HospitalManagement.Test;

import HospitalManagement.Schedule.Schedule;
import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.Patientt.Patient;
import HospitalManagement.CRUD.ListChung;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestSchedule {
    private ListChung<Schedule> dsSchedule = new ListChung<>();
    private ListChung<Patient> dsPatient;
    private ListChung<BenhAn> dsBenhan;

    public TestSchedule(TestPatient testPatient, TestBenhan testBenhan) {
        this.dsPatient = testPatient.getDsPatientList();
        this.dsBenhan = testBenhan.getDsBenhan();
    }

    public void themSchedule() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng lịch cấp thuốc cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin lịch cấp thuốc thứ " + (i + 1) + " ===");

            System.out.print("Mã schedule: ");
            String id = sc.nextLine();

            System.out.print("Mã bệnh án: ");
            String benhanId = sc.nextLine();
            if (dsBenhan.timKiem(benhanId) == null) {
                System.out.println("Không tìm thấy bệnh án có mã: " + benhanId);
                continue;
            }

            System.out.print("Mã bệnh nhân: ");
            String patientId = sc.nextLine();
            if (dsPatient.timKiem(patientId) == null) {
                System.out.println("Không tìm thấy bệnh nhân có mã: " + patientId);
                continue;
            }

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
            System.out.println("Đã thêm thành công!\n");
        }
    }

    public void inSchedule() {
        System.out.println("\nDanh sách lịch cấp thuốc:");
        dsSchedule.inDanhSach();
    }

    public void xoaSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã schedule cần xoá: ");
        String id = sc.nextLine();

        dsSchedule.xoa(id);

        System.out.println("Danh sách sau khi xoá:");
        dsSchedule.inDanhSach();
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

        System.out.println("\nDang sửa thông tin cho schedule mã: " + id);

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

        System.out.println("\nDanh sách schedule sau khi sửa:");
        dsSchedule.inDanhSach();
    }

    public ListChung<Schedule> getDsSchedule() {
        return dsSchedule;
    }
}
