package com.example.springboot.Test;

import com.example.springboot.CRUD.ListChung;
import com.example.springboot.Model.BenhAn;
import com.example.springboot.Model.Room;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestBenhan {
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final ListChung<BenhAn> dsBenhan = new ListChung<>();
    private static final TestRoom testRoom = new TestRoom();
    private static final TestPatient testPatient = new TestPatient();

    static {
        sdf.setLenient(false);
        dsBenhan.setHienThongBao(false);
        testRoom.dsMauRoom();
        testPatient.dsMauPatient();
    }

    public void themBenhan() {
        System.out.print("\nNhap so luong benh an can them: ");
        int soLuong;
        try {
            soLuong = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("So luong khong hop le.");
            return;
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Nhap thong tin benh an thu " + (i + 1) + " ---");

            System.out.print("Nhap ma benh an: ");
            String id = sc.nextLine().trim();
            if (dsBenhan.timKiem(id) != null) {
                System.out.println("ID da ton tai, khong the them.");
                continue;
            }

            System.out.print("Nhap ma benh nhan: ");
            String patientId = sc.nextLine().trim();
            if (testPatient.getPatientList().timKiem(patientId) == null) {
                System.out.println("Khong tim thay benh nhan.");
                continue;
            }

            List<Room> dsRoom = testRoom.getRoomList().getList();
            if (dsRoom.isEmpty()) {
                System.out.println("Khong co phong kham de gan.");
                continue;
            }

            Room roomRandom = dsRoom.get(new Random().nextInt(dsRoom.size()));
            String roomId = roomRandom.getId();
            String doctorId = roomRandom.getDoctorName();

            System.out.println("Phong kham duoc gan: " + roomRandom.getName());
            System.out.println("Bac si phu trach: " + roomRandom.getDoctorName());

            Calendar ngayKham = Calendar.getInstance();
            try {
                System.out.print("Nhap ngay kham (dd/MM/yyyy): ");
                Date date = sdf.parse(sc.nextLine().trim());
                ngayKham.setTime(date);
            } catch (Exception e) {
                System.out.println("Ngay khong hop le.");
                continue;
            }

            System.out.print("Nhap trieu chung: ");
            String trieuChung = sc.nextLine().trim();

            System.out.print("Nhap tien su benh: ");
            String tienSu = sc.nextLine().trim();

            System.out.print("Nhap chan doan: ");
            String chanDoan = sc.nextLine().trim();

            BenhAn ba = new BenhAn(id, patientId, ngayKham, trieuChung, tienSu, chanDoan, roomId);
            dsBenhan.them(ba);
        }
    }
    public void inBenhan() {
    System.out.println("\n=== DANH SACH BENH AN ===");
    System.out.printf("%-5s | %-5s | %-10s | %-20s | %-12s | %-15s | %-15s | %-15s\n",
            "Ma BA", "Ma BN", "Phong", "Bac si", "Ngay kham", "Trieu chung", "Tien su benh", "Chan doan");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------");

    for (BenhAn ba : dsBenhan.getList()) {
        Room room = testRoom.getRoomList().timKiem(ba.getRoomId());
        String tenBacSi = (room != null) ? room.getDoctorName() : "Khong ro";
        String tenPhong = (room != null) ? room.getName() : "Khong ro";
        System.out.printf("%-5s | %-5s | %-10s | %-20s | %-12s | %-15s | %-15s | %-15s\n",
                ba.getId(),ba.getPatientId(),tenPhong,tenBacSi,sdf.format(ba.getNgayKham().getTime()),ba.getTrieuChung(),ba.getTienSuBenh(),ba.getChanDoan());
    }
}

public void timKiemBenhan() {
        System.out.print("Nhap tu khoa tim kiem (ma benh an, ma benh nhan, phong, bac si, trieu chung, chan doan...): ");
        String keyword = sc.nextLine().trim().toLowerCase();
        List<BenhAn> ketQua = new ArrayList<>();
        for (BenhAn ba : dsBenhan.getList()) {
            Room room = testRoom.getRoomList().timKiem(ba.getRoomId());
            String tenBacSi = (room != null) ? room.getDoctorName().toLowerCase() : "";
            String tenPhong = (room != null) ? room.getName().toLowerCase() : "";
            if (ba.getId().toLowerCase().contains(keyword)
                || ba.getPatientId().toLowerCase().contains(keyword)
                || tenPhong.contains(keyword)
                || tenBacSi.contains(keyword)
                || ba.getTrieuChung().toLowerCase().contains(keyword)
                || ba.getTienSuBenh().toLowerCase().contains(keyword)
                || ba.getChanDoan().toLowerCase().contains(keyword)
                || sdf.format(ba.getNgayKham().getTime()).contains(keyword)
            ) {
                ketQua.add(ba);
            }
        }
        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay benh an.");
        } else {
            System.out.println("\n=== KET QUA TIM KIEM BENH AN ===");
            System.out.printf("%-5s | %-5s | %-10s | %-20s | %-12s | %-15s | %-15s | %-15s\n",
                    "Ma BA", "Ma BN", "Phong", "Bac si", "Ngay kham", "Trieu chung", "Tien su benh", "Chan doan");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            for (BenhAn ba : ketQua) {
                Room room = testRoom.getRoomList().timKiem(ba.getRoomId());
                String tenBacSi = (room != null) ? room.getDoctorName() : "Khong ro";
                String tenPhong = (room != null) ? room.getName() : "Khong ro";
                System.out.printf("%-5s | %-5s | %-10s | %-20s | %-12s | %-15s | %-15s | %-15s\n",
                        ba.getId(), ba.getPatientId(), tenPhong, tenBacSi,
                        sdf.format(ba.getNgayKham().getTime()), ba.getTrieuChung(),
                        ba.getTienSuBenh(), ba.getChanDoan());
            }
        }
    }
    public ListChung<BenhAn> getBenhanList() {
        return dsBenhan;
    }
}
