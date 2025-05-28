package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestBenhan {
    private final TestPatient testPatient = new TestPatient();
    private final ArrayList<Patient> dsPatient = testPatient.addList(); // Khởi tạo 1 lần
    private final ListChung<BenhAn> dsBenhAn = new ListChung<>();

    private final Object[][] data = {
        {"BA001", 0, 2024, Calendar.JANUARY, 10, "Sốt, ho", "Cảm cúm"},
        {"BA002", 1, 2024, Calendar.MARCH, 12, "Khó thở", "Viêm phổi"},
        {"BA003", 2, 2024, Calendar.APRIL, 25, "Đau đầu", "Thiếu máu não"}
    };

    public void addBenhAn() {
    if (!dsBenhAn.getDanhSach().isEmpty()) {
        System.out.println("Bệnh án đã tồn tại, không thêm lại.");
        return;
    }

    for (Object[] row : data) {
        String id = (String) row[0];
        int patientIndex = (int) row[1];
        Calendar ngayKham = new GregorianCalendar((int) row[2], (int) row[3], (int) row[4]);
        String trieuChung = (String) row[5];
        String chanDoan = (String) row[6];

        if (dsBenhAn.timKiem(id) == null && patientIndex < dsPatient.size()) {
            Patient p = dsPatient.get(patientIndex);
            dsBenhAn.them(new BenhAn(id, p.getId(), ngayKham, trieuChung, p.getMedicalHistory(), chanDoan));
        }
    }

    System.out.println("Đã thêm danh sách bệnh án mẫu (nếu chưa có).");
}

    public void inBenhAn() {
        dsBenhAn.inDanhSach();
    }

    public void themBenhAn() {
        Scanner scAdd = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh án muốn thêm: ");
        int soLuong = Integer.parseInt(scAdd.nextLine());

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Nhập thông tin bệnh án thứ " + (i + 1) + " ---");

            System.out.print("Mã bệnh án: ");
            String id = scAdd.nextLine();

            if (dsBenhAn.timKiem(id) != null) {
                System.out.println("Mã bệnh án đã tồn tại, vui lòng nhập mã khác.");
                i--;
                continue;
            }

            System.out.print("Mã bệnh nhân liên kết: ");
            String patientId = scAdd.nextLine();

            Patient patient = dsPatient.stream()
                .filter(p -> p.getId().equalsIgnoreCase(patientId))
                .findFirst()
                .orElse(null);

            if (patient == null) {
                System.out.println("Không tìm thấy bệnh nhân với ID: " + patientId);
                continue;
            }

            Calendar ngayKham = null;
            while (ngayKham == null) {
                try {
                    System.out.print("Ngày khám (dd/MM/yyyy): ");
                    Date parsedDate = sdf.parse(scAdd.nextLine().trim());
                    ngayKham = Calendar.getInstance();
                    ngayKham.setTime(parsedDate);
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.print("Triệu chứng: ");
            String trieuChung = scAdd.nextLine();
            System.out.print("Chẩn đoán: ");
            String chanDoan = scAdd.nextLine();

            dsBenhAn.them(new BenhAn(id, patientId, ngayKham, trieuChung, patient.getMedicalHistory(), chanDoan));
        }

        System.out.println("\nDanh sách bệnh án sau khi thêm:");
        dsBenhAn.inDanhSach();
    }

    public void updateBenhAn() {
        Scanner scannerEdit = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần sửa: ");
        String id = scannerEdit.nextLine();

        BenhAn benhAnCu = dsBenhAn.timKiem(id);
        if (benhAnCu == null) {
            System.out.println("Không tìm thấy bệnh án.");
            return;
        }

        System.out.println("Bệnh án hiện tại:\n" + benhAnCu);

        System.out.print("Nhập chẩn đoán mới: ");
        String chanDoanMoi = scannerEdit.nextLine();

        BenhAn benhAnMoi = new BenhAn(
                benhAnCu.getId(),
                benhAnCu.getPatientId(),
                benhAnCu.getNgayKham(),
                benhAnCu.getTrieuChung(),
                benhAnCu.getTienSuBenh(),
                chanDoanMoi
        );

        dsBenhAn.sua(id, benhAnMoi);

        System.out.println("\nDanh sách sau khi sửa:");
        dsBenhAn.inDanhSach();
    }

    public void deleteBenhAn() {
        Scanner snrDelete = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần xoá: ");
        String id = snrDelete.nextLine();

        dsBenhAn.xoa(id);
        System.out.println("Đã xoá thành công!");

        System.out.println("\nDanh sách sau khi xoá:");
        dsBenhAn.inDanhSach();
    }
}
