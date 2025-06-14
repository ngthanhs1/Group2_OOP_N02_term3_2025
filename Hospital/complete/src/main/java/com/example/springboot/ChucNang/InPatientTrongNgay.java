package HospitalManagement.ChucNang;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Model.BenhAn;
import HospitalManagement.Model.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class InPatientTrongNgay{

    public static void in(ListChung<BenhAn> dsBenhan, ListChung<Patient> dsPatient) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        System.out.print("Nhập ngày cần tra cứu bệnh nhân (dd/MM/yyyy): ");
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
        System.out.println("\n=== Danh sách bệnh nhân khám trong ngày " + inputDate + " ===");

        for (BenhAn ba : dsBenhan.getList()) {
            Calendar ngayKham = ba.getNgayKham();
            if (sameDate(ngayKham, targetDate)) {
                Patient p = dsPatient.timKiem(ba.getPatientId());
                if (p != null) {
                    System.out.println("Mã BN: " + p.getId() + " | Tên: " + p.getName() + " | Ngày khám: " + sdf.format(ngayKham.getTime()));
                } else {
                    System.out.println("Bệnh nhân không tồn tại (mã: " + ba.getPatientId() + ")");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có bệnh nhân nào khám trong ngày này.");
        }
    }
    private static boolean sameDate(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
               c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) &&
               c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }
}
