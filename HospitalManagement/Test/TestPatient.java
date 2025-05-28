package HospitalManagement.Test;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestPatient {
    private ListChung<Patient> patientList = new ListChung<>();

    private static final Object[][] data = {
        {"BN001", "Nguyen Thi Lan", 1995, Calendar.MARCH, 10, "Nữ", "Hà Nội", "0123456789", "Không có tiền sử bệnh"},
        {"BN002", "Tran Van Nam", 1999, Calendar.APRIL, 5, "Nam", "Hải Phòng", "0987654321", "Tiểu đường"},
        {"BN003", "Le Hoang Nam", 1988, Calendar.JULY, 20, "Nam", "Đà Nẵng", "0911222333", "Cao huyết áp"}
    };

    // Dùng cho App gọi để có danh sách
    public ArrayList<Patient> addList() {
        ArrayList<Patient> ds = new ArrayList<>();

        for (Object[] row : data) {
            ds.add(new Patient(
                (String) row[0],
                (String) row[1],
                new GregorianCalendar((int) row[2], (int) row[3], (int) row[4]),
                (String) row[5],
                (String) row[6],
                (String) row[7],
                (String) row[8]
            ));
        }

        return ds;
    }

    public void themDanhSachMau() {
        ArrayList<Patient> ds = addList();
        for (Patient p : ds) {
            patientList.them(p);
        }
        System.out.println("Đã thêm danh sách bệnh nhân mẫu.");
    }

    public void addPatient() {
        Scanner srk = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh nhân cần thêm: ");
        int n = Integer.parseInt(srk.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin bệnh nhân thứ " + (i + 1));

            System.out.print("Mã bệnh nhân: ");
            String id = srk.nextLine();

            System.out.print("Họ tên: ");
            String name = srk.nextLine();

            Calendar dob = null;
            while (dob == null) {
                try {
                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
                    String[] parts = srk.nextLine().trim().split("/");
                    Date date = sdf.parse(String.format("%02d/%02d/%s",
                            Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]));
                    dob = Calendar.getInstance();
                    dob.setTime(date);
                } catch (Exception e) {
                    System.out.println("Ngày sinh không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.print("Giới tính: ");
            String gender = srk.nextLine();

            System.out.print("Địa chỉ: ");
            String address = srk.nextLine();

            System.out.print("Số điện thoại: ");
            String phone = srk.nextLine();

            System.out.print("Tiền sử bệnh: ");
            String medicalHistory = srk.nextLine();

            Patient p = new Patient(id, name, dob, gender, address, phone, medicalHistory);
            patientList.them(p);
        }

        System.out.println("\nDanh sách bệnh nhân sau khi thêm:");
        patientList.inDanhSach();
    }

    public void inPatient() {
        patientList.inDanhSach();
    }

    public void updatePatient() {
        Scanner snr = new Scanner(System.in);
        System.out.print("Nhập ID bệnh nhân cần sửa: ");
        String id = snr.nextLine();

        Patient old = patientList.timKiem(id);
        if (old == null) {
            System.out.println("Không tìm thấy bệnh nhân.");
            return;
        }

        System.out.println("Đang sửa thông tin cho bệnh nhân: " + old.getName());

        System.out.print("Tên mới: ");
        String name = snr.nextLine();

        System.out.print("Giới tính mới: ");
        String gender = snr.nextLine();

        System.out.print("Địa chỉ mới: ");
        String address = snr.nextLine();

        System.out.print("Số điện thoại mới: ");
        String phone = snr.nextLine();

        System.out.print("Tiền sử bệnh mới: ");
        String history = snr.nextLine();

        Calendar dob = old.getDob(); // giữ nguyên ngày sinh

        Patient newP = new Patient(id, name, dob, gender, address, phone, history);
        patientList.sua(id, newP);

        System.out.println("\nDanh sách sau khi sửa:");
        patientList.inDanhSach();
    }

    public void deletePatient() {
        Scanner snr = new Scanner(System.in);
        System.out.print("Nhập ID bệnh nhân cần xóa: ");
        String id = snr.nextLine();

        patientList.xoa(id);

        System.out.println("\nDanh sách sau khi xóa:");
        patientList.inDanhSach();
    }
}
