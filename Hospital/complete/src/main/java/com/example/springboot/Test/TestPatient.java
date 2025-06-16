package com.example.springboot.Test;

import com.example.springboot.CRUD.ListChung;
import com.example.springboot.Model.BenhAn;
import com.example.springboot.Model.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestPatient {
    private static  ListChung<Patient> patientList = new ListChung<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean daThemMau = false;

    private static final Object[][] data = {
        {"BN001", "Nguyen Van Thanh", 2005, Calendar.MARCH, 19, "Nam", "Ha Noi", "0123456789"},
        {"BN002", "Nguyễn Thị Trang", 2006, Calendar.APRIL, 5, "Nu", "Vinh Phuc", "0987654321"},
        {"BN003", "Lê Hoàng Nam", 1988, Calendar.JULY, 20, "Nam", "Đà Nẵng", "0911222333"}
    };

    public void dsMauPatient() {
        if (daThemMau) return;
        patientList.setHienThongBao(false);

        for (Object[] row : data) {
            Calendar dob = new GregorianCalendar((int) row[2], (int) row[3], (int) row[4]);
            Patient p = new Patient(
                (String) row[0],
                (String) row[1],
                dob,
                (String) row[5],
                (String) row[6],
                (String) row[7]
            );
            patientList.them(p);
        }

        daThemMau = true;
    }

    public ListChung<Patient> getPatientList() {
        return patientList;
    }
    public void addPatient() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhap so luong benh nhan can them: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap benh nhan thu " + (i + 1));

            System.out.print("Ma benh nhan: ");
            String id = scanner.nextLine();
            if (patientList.tonTai(id)) {
                System.out.println("Ma benh nhan da ton tai. Bo qua.");
                continue;
            }

            System.out.print("Ho ten: ");
            String name = scanner.nextLine();

            Calendar dob = null;
            while (dob == null) {
                try {
                    System.out.print("Ngay sinh (dd/MM/yyyy): ");
                    Date date = sdf.parse(scanner.nextLine());
                    dob = Calendar.getInstance();
                    dob.setTime(date);
                } catch (Exception e) {
                    System.out.println("Ngay sinh khong hop le. Vui long nhap lai.");
                }
            }

            System.out.print("Gioi tinh: ");
            String gender = scanner.nextLine();

            System.out.print("Dia chi: ");
            String address = scanner.nextLine();

            System.out.print("So dien thoai: ");
            String phone = scanner.nextLine();

            System.out.print("Tien su benh: ");
            String histo = scanner.nextLine();

            Patient p = new Patient(id, name, dob, gender, address, phone);
            patientList.them(p);
        }

        System.out.println("\nDanh sach sau khi them:");
        inPatient();
    }

    public void inPatient() {
        System.out.println("__Danh sach benh nhan__\n");
        if (patientList.getList().isEmpty()) {
            System.out.println("Danh sach benh nhan rong.");
            return;
        }

        inTieuDe();
        for (Patient p : patientList.getList()) {
            System.out.println(p);
        }
    }

    private void inTieuDe() {
        System.out.printf("%-10s | %-18s | %-12s | %-3s | %-6s | %-12s | %-10s\n","Ma BN", "Ho ten", "Ngay sinh", "Tuoi", "Gioi", "Dia chi", "SDT");
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void updatePatient() {
        System.out.print("Nhap ID benh nhan can sua: ");
        String id = scanner.nextLine();

        Patient old = patientList.timKiem(id);
        if (old == null) {
            System.out.println("Khong tim thay benh nhan.");
            return;
        }

        System.out.println("Dang sua thong tin cho: " + old.getName());

        System.out.print("Ten moi: ");
        String name = scanner.nextLine();

        System.out.print("Gioi tinh moi: ");
        String gender = scanner.nextLine();

        System.out.print("Dia chi moi: ");
        String address = scanner.nextLine();

        System.out.print("So dien thoai moi: ");
        String phone = scanner.nextLine();

        Patient updated = new Patient(id, name, old.getDob(), gender, address, phone);
        patientList.sua(id, updated);

        System.out.println("\nDa cap nhat. Danh sach moi:");
        inPatient();
    }

    public void deletePatient() {
        System.out.print("Nhập ID bệnh nhân cần xoá: ");
        String id = scanner.nextLine();

        if (patientList.xoa(id)) {
            System.out.println("Đã xoá.");
        } else {
            System.out.println("Không tìm thấy bệnh nhân.");
        }

        System.out.println("\nDanh sách còn lại:");
        inPatient();
    }

    public void timKiemPatient() {
        Scanner snr = new Scanner(System.in);
        System.out.print("Nhap tu khoa tim kiem (ID, ten, dia chi, SDT...): ");
        String keyword = snr.nextLine();
        List<Patient> ketQua = searchByAnyField(patientList.getList(), keyword);
        if (ketQua.isEmpty()) {
            System.out.println("Khong tim thay benh nhan.");
        } else {
            System.out.println("__Ket qua tim kiem__:");
            inTieuDe();
            for (Patient p : ketQua) {
                System.out.println(p);
            }
        }
    }

    private List<Patient> searchByAnyField(List<Patient> patients, String keywordToFind) {
        String lowerKeyword = keywordToFind.toLowerCase();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getId().toLowerCase().contains(lowerKeyword)
                || p.getName().toLowerCase().contains(lowerKeyword)
                || p.getAddress().toLowerCase().contains(lowerKeyword)
                || p.getGender().toLowerCase().contains(lowerKeyword)
                || p.getPhone().toLowerCase().contains(lowerKeyword)
                || sdf.format(p.getDob().getTime()).contains(lowerKeyword)
                || String.valueOf(p.getAge()).contains(lowerKeyword)
            ) {
                result.add(p);
            }
        }
        return result;
    }

    public void thongKeSoLuong() {
        System.out.println("Tổng số bệnh nhân: " + patientList.getList().size());
    }

    public static boolean checkTonTaiBenhNhan(String id) {
        return patientList.tonTai(id);
    }

    public static Patient getBenhNhanTheoMa(String id) {
        return patientList.timKiem(id);
    }
}
