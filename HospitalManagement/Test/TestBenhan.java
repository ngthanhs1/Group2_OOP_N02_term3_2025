package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
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
        dsBenhan.setHienThongBao(false);
        testDoctor.dsDoctor(); 
        testRoom.dsMauRoom();
        testPatient.dsMauPatient();
        
        BenhAn.setDoctorList(testDoctor.getDoctorList().getList());

    }

    public void themBenhan() {
        System.out.print("\nNhập số lượng bệnh án cần thêm: ");
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

            // Gán phòng và bác sĩ sau khi nhập mã bệnh nhân
            List<Room> dsRoom = testRoom.getRoomList().getList();
            if (dsRoom.isEmpty()) {
                System.out.println("Không có phòng khám để gán.");
                continue;
            }

            Room roomRandom = dsRoom.get(new Random().nextInt(dsRoom.size()));
            String roomId = roomRandom.getId();
            String doctorId = roomRandom.getDoctorId();

            System.out.println("Phòng khám được gán: " + roomRandom.getName());
            System.out.println("Bác sĩ phụ trách: " + roomRandom.getDoctorName());

            // Nhập thông tin khám
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

            BenhAn ba = new BenhAn(id, patientId, ngayKham, trieuChung, tienSu, chanDoan, doctorId, roomId);
            dsBenhan.them(ba);
        }
    }

    public void inBenhan() {
        System.out.println("\n=== DANH SÁCH BỆNH ÁN ===");
        for (BenhAn ba : dsBenhan.getList()) {
            System.out.println(ba);
        }
    }

    public ListChung<BenhAn> getBenhanList() {
        return dsBenhan;
    }
}