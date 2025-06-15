package com.example.springboot.Test;

import com.example.springboot.CRUD.ListChung;
import com.example.springboot.Model.BenhAn;
import com.example.springboot.Model.Patient;
import com.example.springboot.Model.Schedule;
import com.example.springboot.ChucNang.LichCapThuoc;

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

        System.out.print("Nhap so luong lich cap thuoc can them: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n;) {
            System.out.println("\n_Nhap thong tin lich cap thuoc thu " + (i + 1) + ":");

            System.out.print("Ma schedule: ");
            String id = sc.nextLine();
            if (dsSchedule.timKiem(id) != null) {
                System.out.println("Ma schedule da ton tai. Vui long nhap ma khac.");
                continue;
            }

            System.out.print("Ma benh an: ");
            String benhanId = sc.nextLine();
            BenhAn benhAn = dsBenhan.timKiem(benhanId);
            if (benhAn == null) {
                System.out.println("Khong tim thay benh an co ma: " + benhanId);
                continue;
            }

            String patientId = benhAn.getPatientId();
            System.out.println("-> Ma benh nhan: " + patientId);

            Calendar date = null;
            while (date == null) {
                try {
                    System.out.print("Ngay cap thuoc (dd/MM/yyyy): ");
                    Date d = sdf.parse(sc.nextLine().trim());
                    date = Calendar.getInstance();
                    date.setTime(d);
                } catch (Exception e) {
                    System.out.println("Ngay khong hop le, vui long nhap lai.");
                }
            }

            System.out.print("Ten thuoc: ");
            String tenthuoc = sc.nextLine();

            System.out.print("So luong: ");
            String soluong = sc.nextLine();

            Schedule s = new Schedule(id, benhanId, patientId, date, tenthuoc, soluong);
            dsSchedule.them(s);
            System.out.println("-> Da them lich cap thuoc thanh cong!");
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

    public void timKiemSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tu khoa tim kiem (ma schedule, ma benh an, ma benh nhan, ten thuoc...): ");
        String keyword = sc.nextLine().toLowerCase();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Schedule> ketQua = new ArrayList<>();
        for (Schedule s : dsSchedule.getList()) {
            if (s.getId().toLowerCase().contains(keyword)
                || s.getBenhanId().toLowerCase().contains(keyword)
                || s.getPatientId().toLowerCase().contains(keyword)
                || s.getTenthuoc().toLowerCase().contains(keyword)
                || s.getSoluong().toLowerCase().contains(keyword)
                || sdf.format(s.getDate().getTime()).contains(keyword)
            ) {
                ketQua.add(s);
            }
        }
        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay lich cap thuoc.");
        } else {
            System.out.println("__Ket qua tim kiem lich cap thuoc__:");
            System.out.printf("%-8s | %-8s | %-8s | %-15s | %-10s | %-13s\n",
                    "Ma BT", "Ma BA", "Ma BN", "Ngay cap", "Ten thuoc", "So luong(vien)");
            System.out.println("-----------------------------------------------------------------------------------");
            for (Schedule s : ketQua) {
                System.out.printf("%-8s | %-8s | %-8s | %-15s | %-10s | %-13s\n",
                    s.getId(), s.getBenhanId(), s.getPatientId(),
                    sdf.format(s.getDate().getTime()), s.getTenthuoc(), s.getSoluong());
            }
        }
    }

    public ListChung<Schedule> getDsSchedule() {
        return dsSchedule;
    }
    public void inCapThuocTrongNgay() {
    LichCapThuoc inTheoNgay = new LichCapThuoc(dsSchedule);
    inTheoNgay.inTheoNgay();
}

}
