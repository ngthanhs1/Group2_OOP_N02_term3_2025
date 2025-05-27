import java.util.ArrayList;

public class BenhanList {

    private ArrayList<BenhAn> danhSachBenhAn = new ArrayList<>();

    public void themBenhAn(BenhAn ba) {
        danhSachBenhAn.add(ba);
    }

    public void suaBenhAn(String id, String chuanDoanMoi) {
        for (BenhAn ba : danhSachBenhAn) {
            if (ba.getId().equals(id)) {
                ba.setChuandoan(chuanDoanMoi);
                System.out.println("Đã cập nhật chẩn đoán.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh án với ID: " + id);
    }

    public void xoaBenhAn(String id) {
        for (int i = 0; i < danhSachBenhAn.size(); i++) {
            if (danhSachBenhAn.get(i).getId().equals(id)) {
                danhSachBenhAn.remove(i);
                System.out.println("✅ Đã xoá bệnh án.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh án với ID: " + id);
    }

    public void inDanhSachBenhAn() {
        if (danhSachBenhAn.isEmpty()) {
            System.out.println("Danh sách bệnh án trống.");
        } else {
            for (BenhAn ba : danhSachBenhAn) {
                System.out.println(ba);
            }
        }
    }
}
