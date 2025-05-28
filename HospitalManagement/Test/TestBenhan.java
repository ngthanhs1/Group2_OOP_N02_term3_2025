package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Patientt.Patient;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestBenhan {
    private static final TestPatient testPatient = new TestPatient();
    private static final ArrayList<Patient> dsPatient = testPatient.addList();
    private final ListChung<BenhAn> dsBenhAn = new ListChung<>();

    public void addBenhAn() {
        themBenhAnMau();
        System.out.println("\nDanh sách bệnh án mẫu:");
        dsBenhAn.inDanhSach();
    }

    private void themBenhAnMau() {
        themNeuChuaTonTai("BA001", 0, new GregorianCalendar(2024, Calendar.JANUARY, 10), "Sốt, ho", "Cảm cúm");
        themNeuChuaTonTai("BA002", 1, new GregorianCalendar(2024, Calendar.MARCH, 12), "Khó thở", "Viêm phổi");
        themNeuChuaTonTai("BA003", 2, new GregorianCalendar(2024, Calendar.APRIL, 25), "Đau đầu", "Thiếu máu não");
    }

    private void themNeuChuaTonTai(String id, int patientIndex, Calendar ngayKham, String trieuChung, String chanDoan) {
        if (dsBenhAn.timKiem(id) == null && patientIndex < dsPatient.size()) {
            Patient p = dsPatient.get(patientIndex);
            dsBenhAn.them(new BenhAn(id, p.getId(), ngayKham, trieuChung, p.getMedicalHistory(), chanDoan));
        }
    }

    public void inBenhAn() {
        dsBenhAn.inDanhSach();
    }

    public void themBenhAn() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        System.out.print("Nhập số lượng bệnh án muốn thêm: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Nhập thông tin bệnh án thứ " + (i + 1) + " ---");

            System.out.print("Mã bệnh án: ");
            String id = sc.nextLine();

            if (dsBenhAn.timKiem(id) != null) {
                System.out.println("Mã bệnh án đã tồn tại, vui lòng nhập mã khác.");
                i--;
                continue;
            }

            System.out.print("Mã bệnh nhân liên kết: ");
            String patientId = sc.nextLine();

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
                    Date parsedDate = sdf.parse(sc.nextLine().trim());
                    ngayKham = Calendar.getInstance();
                    ngayKham.setTime(parsedDate);
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                }
            }

            System.out.print("Triệu chứng: ");
            String trieuChung = sc.nextLine();
            System.out.print("Chẩn đoán: ");
            String chanDoan = sc.nextLine();

            dsBenhAn.them(new BenhAn(id, patientId, ngayKham, trieuChung, patient.getMedicalHistory(), chanDoan));
        }

        System.out.println("\nDanh sách bệnh án sau khi thêm:");
        dsBenhAn.inDanhSach();
    }

    public void updateBenhAn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần sửa: ");
        String id = sc.nextLine();

        BenhAn cu = dsBenhAn.timKiem(id);
        if (cu == null) {
            System.out.println("Không tìm thấy bệnh án.");
            return;
        }

        System.out.println("Bệnh án hiện tại:\n" + cu);
        System.out.print("Nhập chẩn đoán mới: ");
        String chanDoanMoi = sc.nextLine();

        BenhAn moi = new BenhAn(cu.getId(), cu.getPatientId(), cu.getNgayKham(), cu.getTrieuChung(), cu.getTienSuBenh(), chanDoanMoi);
        dsBenhAn.sua(id, moi);

        System.out.println("\nDanh sách sau khi sửa:");
        dsBenhAn.inDanhSach();
    }

    public void deleteBenhAn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần xoá: ");
        String id = sc.nextLine();

        dsBenhAn.xoa(id);

        System.out.println("\nDanh sách sau khi xoá:");
        dsBenhAn.inDanhSach();
    }
}
