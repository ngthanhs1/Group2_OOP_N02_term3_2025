package HospitalManagement.BenhAn;

import java.util.ArrayList;

public class BenhanList {
    private ArrayList<BenhAn> danhSachBenhAn = new ArrayList<>();

    public void themBenhAn(BenhAn ba) {
        danhSachBenhAn.add(ba);
    }

    public void suaBenhAn(String id, String chuanDoanMoi) {
        for (BenhAn ba : danhSachBenhAn) {
            if (ba.getId().equalsIgnoreCase(id)) {
                ba.setChuandoan(chuanDoanMoi);
                System.out.println("Đã cập nhật chẩn đoán cho bệnh án có ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh án với ID: " + id);
    }

    public void xoaBenhAn(String id) {
        boolean removed = danhSachBenhAn.removeIf(ba -> ba.getId().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Đã xoá bệnh án có ID: " + id);
        } else {
            System.out.println("Không tìm thấy bệnh án với ID: " + id);
        }
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
