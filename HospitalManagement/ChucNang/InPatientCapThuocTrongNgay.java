package HospitalManagement.ChucNang;

import HospitalManagement.Schedule.Schedule;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class InPatientCapThuocTrongNgay {

    public static void in(ListChung<Schedule> dsSchedule, ListChung<Patient> dsPatient) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập ngày cần tra cứu cấp thuốc (dd/MM/yyyy): ");
        String inputDate = sc.nextLine();
        Calendar targetDate = null;

        try {
            Date parsedDate = sdf.parse(inputDate.trim());
            targetDate = Calendar.getInstance();
            targetDate.setTime(parsedDate);
        } catch (Exception e) {
            System.out.println("Ngày không hợp lệ.");
            return;
        }

        boolean found = false;
        System.out.println("\n=== DANH SÁCH BỆNH NHÂN ĐƯỢC CẤP THUỐC TRONG NGÀY " + inputDate + " ===");
        System.out.printf("%-10s | %-20s | %-15s | %-10s\n", "Mã BN", "Tên bệnh nhân", "Tên thuốc", "Số lượng");

        for (Schedule s : dsSchedule.getList()) {
            Calendar ngayCap = s.getDate();  // sửa chỗ này
            if (sameDate(ngayCap, targetDate)) {
                Patient p = dsPatient.timKiem(s.getPatientId());
                if (p != null) {
                    System.out.printf("%-10s | %-20s | %-15s | %-10s\n",
                            p.getId(), p.getName(), s.getTenthuoc(), s.getSoluong());
                    found = true;
                } else {
                    System.out.println("Không tìm thấy bệnh nhân có mã: " + s.getPatientId());
                }
            }
        }

        if (!found) {
            System.out.println("Không có bệnh nhân nào được cấp thuốc trong ngày này.");
        }
    }

    private static boolean sameDate(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
               c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) &&
               c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }
}
