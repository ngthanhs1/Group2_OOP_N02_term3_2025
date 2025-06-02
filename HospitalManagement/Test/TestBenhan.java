package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.Room.Doctor;
import HospitalManagement.Room.Room;
import HospitalManagement.CRUD.ListChung;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestBenhan {
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final ListChung<BenhAn> dsBenhan = new ListChung<>();

    private static final TestDoctor testDoctor = new TestDoctor();
    private static final TestRoom testRoom = new TestRoom();
    private static final TestPatient testPatient = new TestPatient();

    static {
        sdf.setLenient(false);
        testDoctor.dsMauDoctor();    // Danh sách bác sĩ mẫu
        testRoom.dsMauRoom();        // Danh sách phòng khám mẫu
        testPatient.dsMauPatient();  // Danh sách bệnh nhân mẫu
    }

    public void themBenhan() {
        System.out.print("Nhập số lượng bệnh án cần thêm: ");
        int soLuong;
        try {
            soLuong = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ.");
            return;
        }

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n--- Nhập thông tin bệnh án thứ " + (i + 1) + " ---");

            System.out.print("Nhập mã bệnh án: ");
            String id = sc.nextLine().trim();
            if (dsBenhan.timKiem(id) != null) {
                System.out.println("ID đã tồn tại, không thể thêm.");
                continue;
            }

            System.out.print("Nhập mã bệnh nhân: ");
            String patientId = sc.nextLine().trim();
            if (testPatient.getPatientList().timKiem(patientId) == null) {
                System.out.println("Không tìm thấy bệnh nhân.");
                continue;
            }

            System.out.print("Nhập ngày khám (dd/MM/yyyy): ");
            Calendar ngayKham = Calendar.getInstance();
            try {
                Date date = sdf.parse(sc.nextLine().trim());
                ngayKham.setTime(date);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ.");
                continue;
            }

            System.out.print("Nhập triệu chứng: ");
            String trieuChung = sc.nextLine().trim();

            System.out.print("Nhập tiền sử bệnh: ");
            String tienSu = sc.nextLine().trim();

            System.out.print("Nhập chẩn đoán: ");
            String chanDoan = sc.nextLine().trim();

            // Chọn ngẫu nhiên phòng và bác sĩ tương ứng
            List<Room> dsRoom = testRoom.getRoomList().getList();
            if (dsRoom.isEmpty()) {
                System.out.println("Không có phòng khám để gán.");
                continue;
            }
            Room roomRandom = dsRoom.get(new Random().nextInt(dsRoom.size()));
            String roomId = roomRandom.getId();
            String doctorId = roomRandom.getDoctorId();

            System.out.println("Đã gán phòng khám: " + roomRandom.getName() +
                               " | Bác sĩ phụ trách: " + roomRandom.getDoctorName());

            BenhAn ba = new BenhAn(id, patientId, ngayKham, trieuChung, tienSu, chanDoan, doctorId, roomId);
            dsBenhan.them(ba);
            System.out.println("Đã thêm bệnh án thành công.");
        }
    }

    public void inBenhan() {
        System.out.println("=== DANH SÁCH BỆNH ÁN ===");
        for (BenhAn ba : dsBenhan.getList()) {
            System.out.println(ba);
        }
    }

    public ListChung<BenhAn> getBenhanList() {
        return dsBenhan;
    }

    public void dsMauBenhAn() {
        ArrayList<BenhAn> dsMau = new ArrayList<>();

        try {
            Calendar ngay1 = Calendar.getInstance();
            Calendar ngay2 = Calendar.getInstance();
            ngay1.setTime(sdf.parse("01/06/2024"));
            ngay2.setTime(sdf.parse("05/06/2024"));

            dsMau.add(new BenhAn("BA01", "BN01", ngay1, "Sốt nhẹ", "Không rõ", "Cảm lạnh", "BS01", "P01"));
            dsMau.add(new BenhAn("BA02", "BN02", ngay2, "Ho", "Hen suyễn", "Viêm họng", "BS02", "P02"));
        } catch (Exception e) {
            System.out.println("Lỗi định dạng ngày!");
        }

        dsBenhan.addList(dsMau);
    }
}
