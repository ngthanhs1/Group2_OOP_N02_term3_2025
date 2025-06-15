package com.example.springboot.ChucNang;

import com.example.springboot.CRUD.ListChung;
import com.example.springboot.Model.Schedule;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

public class LichCapThuoc {

    private ListChung<Schedule> dsSchedule;

    public LichCapThuoc(ListChung<Schedule> dsSchedule) {
        this.dsSchedule = dsSchedule;
    }

    public void inTheoNgay() {
        if (dsSchedule == null || dsSchedule.getList().isEmpty()) {
            System.out.println("Danh sách lịch cấp thuốc trống.");
            return;
        }

        Scanner scv = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Calendar searchDate = null;

        while (searchDate == null) {
            try {
                System.out.print("Nhập ngày cần in cấp thuốc (dd/MM/yyyy): ");
                Date d = sdf.parse(scv.nextLine().trim());
                searchDate = Calendar.getInstance();
                searchDate.setTime(d);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ, vui lòng nhập lại.");
            }
        }

        boolean found = false;
        System.out.println("\n--- Danh sách lịch cấp thuốc trong ngày ---");
        System.out.printf("%-8s | %-8s | %-8s | %-15s | %-10s | %-13s\n",
                "Mã BT", "Mã BA", "Mã BN", "Ngày cấp", "Tên thuốc", "Số lượng(viên)");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Schedule s : dsSchedule.getList()) {
            if (sameDay(s.getDate(), searchDate)) {
                System.out.printf("%-8s | %-8s | %-8s | %-15s | %-10s | %-13s\n",
                        s.getId(), s.getBenhanId(), s.getPatientId(),
                        sdf.format(s.getDate().getTime()), s.getTenthuoc(), s.getSoluong());
                found = true;
            }
        }

        if (!found) {
            System.out.println("→ Không có lịch cấp thuốc nào trong ngày đã chọn.");
        }
    }

    private boolean sameDay(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
            && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
            && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
    }
}
