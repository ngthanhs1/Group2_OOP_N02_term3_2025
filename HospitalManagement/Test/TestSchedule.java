// package HospitalManagement.Test;

// import HospitalManagement.Schedule.Schedule;
// import HospitalManagement.Schedule.ScheduleList;

// import java.util.Calendar;
// import java.util.Scanner;

// public class TestSchedule {
//     private final ScheduleList list = new ScheduleList();
//     private final Scanner sc = new Scanner(System.in);

//     public void khoitaoBAPT() {
//         System.out.println("Thông tin đơn thuốc: ");
//         list.them(new Schedule("DT001", "BA001", "BN001", Calendar.getInstance(), "thuốc A", "10"));
//         list.them(new Schedule("DT002", "BA002", "BN002", Calendar.getInstance(), "dopamin", "1"));
//         list.them(new Schedule("DT003", "BA003", "BN003", Calendar.getInstance(), "thuốc B", "50"));
//     }

//     public void themTuBanPhim() {
//         System.out.print("Nhập ID đơn thuốc: ");
//         String id = sc.nextLine();

//         System.out.print("Nhập ID bệnh án: ");
//         String benhAnId = sc.nextLine();

//         System.out.print("Nhập ID bệnh nhân: ");
//         String patientId = sc.nextLine();

//         System.out.print("Nhập tên thuốc: ");
//         String tenThuoc = sc.nextLine();

//         System.out.print("Nhập số lượng: ");
//         String soLuong = sc.nextLine();

//         Calendar ngayKeDon = Calendar.getInstance(); // Thời gian hiện tại

//         Schedule s = new Schedule(id, benhAnId, patientId, ngayKeDon, tenThuoc, soLuong);
//         list.them(s);
//     }

//     public void updateSchedule() {
//         System.out.print("Nhập ID đơn thuốc cần sửa: ");
//         String id = sc.nextLine();

//         System.out.print("Tên thuốc mới: ");
//         String tenThuoc = sc.nextLine();

//         System.out.print("Số lượng mới: ");
//         String soLuong = sc.nextLine();

//         list.sua(id, tenThuoc, soLuong);
//     }

//     public void xoaSchedule() {
//         System.out.print("Nhập ID đơn thuốc cần xoá: ");
//         String id = sc.nextLine();
//         list.xoa(id);
//     }

//     public void timKiem() {
//         System.out.print("Nhập ID đơn thuốc: ");
//         String id = sc.nextLine();
//         Schedule s = list.tim(id);

//         if (s != null) {
//             System.out.println("Tìm thấy: " + s);
//         } else {
//             System.out.println("Không tìm thấy.");
//         }
//     }

//     public void inDanhSachSchedule() {
//         list.inTatCa();
//     }
// }
