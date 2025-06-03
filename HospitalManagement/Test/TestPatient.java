package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;
import HospitalManagement.ChucNang.PatientSearch;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestPatient {
    private static final ListChung<Patient> patientList = new ListChung<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean daThemMau = false;

    private static final Object[][] data = {
        {"BN001", "Nguyễn Văn Thành", 2005, Calendar.MARCH, 19, "Nam", "Hà Nội", "0123456789"},
        {"BN002", "Nguyễn Thị Trang", 2006, Calendar.APRIL, 5, "Nữ", "Vĩnh Phúc", "0987654321"},
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
        System.out.println("Đã thêm danh sách bệnh nhân mẫu.");
    }

    public ListChung<Patient> getPatientList() {
        return patientList;
    }

    public void addPatient() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh nhân cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập bệnh nhân thứ " + (i + 1));

            System.out.print("Mã bệnh nhân: ");
            String id = scanner.nextLine();
            if (patientList.tonTai(id)) {
                System.out.println("Mã bệnh nhân đã tồn tại. Bỏ qua.");
                continue;
            }

            System.out.print("Họ tên: ");
            String name = scanner.nextLine();

            Calendar dob = null;
            while (dob == null) {
                try {
                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
                    Date date = sdf.parse(scanner.nextLine());
                    dob = Calendar.getInstance();
                    dob.setTime(date);
                } catch (Exception e) {
                    System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.print("Giới tính: ");
            String gender = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String address = scanner.nextLine();

            System.out.print("Số điện thoại: ");
            String phone = scanner.nextLine();

            System.out.print("Tiền sử bệnh: ");
            String history = scanner.nextLine();

            Patient p = new Patient(id, name, dob, gender, address, phone);
            patientList.them(p);
        }

        System.out.println("\nDanh sách sau khi thêm:");
        inPatient();
    }

    public void inPatient() {
        if (patientList.getList().isEmpty()) {
            System.out.println("Danh sách bệnh nhân rỗng.");
            return;
        }
    
        inTieuDe();
        for (Patient p : patientList.getList()) {
            System.out.println(p);
        }
    }

    private void inTieuDe() {
        System.out.printf("%-10s | %-20s | %-12s | %-3s | %-6s | %-15s | %-11s\n",
                "Mã BN", "Họ tên", "Ngày sinh", "Tuổi", "Giới", "Địa chỉ", "SĐT");
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void updatePatient() {
        System.out.print("Nhập ID bệnh nhân cần sửa: ");
        String id = scanner.nextLine();

        Patient old = patientList.timKiem(id);
        if (old == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        System.out.println("Đang sửa thông tin cho: " + old.getName());

        System.out.print("Tên mới: ");
        String name = scanner.nextLine();

        System.out.print("Giới tính mới: ");
        String gender = scanner.nextLine();

        System.out.print("Địa chỉ mới: ");
        String address = scanner.nextLine();

        System.out.print("Số điện thoại mới: ");
        String phone = scanner.nextLine();

        Patient updated = new Patient(id, name, old.getDob(), gender, address, phone);
        patientList.sua(id, updated);

        System.out.println("\nĐã cập nhật. Danh sách mới:");
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
        System.out.print("Nhập từ khóa tìm kiếm (ID, tên, địa chỉ, SĐT...): ");
        String keyword = snr.nextLine();
        List<Patient> ketQua = new PatientSearch().searchByAnyField(patientList.getList(), keyword);
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy bệnh nhân.");
        } else {
            System.out.println("__Kết quả tìm kiếm__:");
            inTieuDe();
            for (Patient p : ketQua) {
                System.out.println(p);
            }
        }
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
