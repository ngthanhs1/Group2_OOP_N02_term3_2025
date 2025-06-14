package HospitalManagement.CRUD;
// package HospitalManagement.BenhAn;

// import java.util.ArrayList;
// import java.util.Optional;

// public class BenhanList {
//     private final ArrayList<BenhAn> danhSach = new ArrayList<>();
//     public void themBenhAn(BenhAn ba) {
//         if (ba == null) {
//             System.out.println("Bệnh án không hợp lệ.");
//             return;
//         }
//         Optional<BenhAn> exists = danhSach.stream()
//             .filter(x -> x.getId().equalsIgnoreCase(ba.getId()))
//             .findFirst();
//         if (exists.isPresent()) {
//             System.out.println("Đã tồn tại bệnh án với ID: " +ba.getId());
//         } else {
//             danhSach.add(ba);
//             System.out.println("Thêm bệnh án thành công với ID: "+ba.getId());
//         }
//     }
//     public void suaBenhAn(String id, String chuanDoanMoi) {
//         if (id == null || chuanDoanMoi == null || chuanDoanMoi.isBlank()) {
//             System.out.println("Tham số nhập vào không hợp lệ.");
//             return;
//         }
//         for (BenhAn ba : danhSach) {
//             if (ba.getId().equalsIgnoreCase(id)) {
//                 String old = ba.getChanDoan();
//                 ba.setChanDoan(chuanDoanMoi);
//                 System.out.println("Đã cập nhật chẩn đoán từ '" + old + "' sang '" + chuanDoanMoi + "' cho bệnh án ID: " + id);
//                 return;
//             }
//         }
//         System.out.println("Không tìm thấy bệnh án với ID: " + id);
//     }
//     public void xoaBenhAn(String id) {
//         if (id == null) {
//             System.out.println("ID bệnh án không hợp lệ.");
//             return;
//         }
//         boolean removed = danhSach.removeIf(ba->ba.getId().equalsIgnoreCase(id));
//         if (removed) {
//             System.out.println("Đã xoá bệnh án với ID: "+ id);
//         } else {
//             System.out.println("Không tìm thấy bệnh án với ID: "+ id);
//         }
//     }
//     public void inDanhSachBenhAn() {
//         if (danhSach.isEmpty()) {
//             System.out.println("Danh sách bệnh án hiện đang trống.");
//         } else {
//             System.out.println("Danh sách bệnh án:");
//             for (BenhAn ba : danhSach) {
//                 System.out.println(ba);
//             }
//         }
//     }
//      //Tìm bệnh án theo ID, trả về Optional
//     public Optional<BenhAn> timBenhAnTheoId(String id) {
//         return danhSach.stream()
//             .filter(ba -> ba.getId().equalsIgnoreCase(id))
//             .findFirst();
//     }
//      // Lấy danh sách bệnh án nội bộ
//     public ArrayList<BenhAn> getDanhSach() {
//         return new ArrayList<>(danhSach);
//     }
// }