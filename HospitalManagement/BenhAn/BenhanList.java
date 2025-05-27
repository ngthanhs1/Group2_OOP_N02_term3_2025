package HospitalManagement.BenhAn;
import java.util.ArrayList;

public class BenhanList {

    ArrayList<BenhAn> danhSachBenhAn = new ArrayList<>();

    public ArrayList<BenhAn> themBenhAn(BenhAn ba) {
        danhSachBenhAn.add(ba);
        return danhSachBenhAn;
    }

    public ArrayList<BenhAn> suaBenhAn(String chuanDoanMoi, String id) {
        for (BenhAn ba : danhSachBenhAn) {
            if (ba.getId().equals(id)) {
                ba.setChuandoan(chuanDoanMoi);
                System.out.println("Đã cập nhật chẩn đoán.");
                break;
            }
        }
        return danhSachBenhAn;
    }

    public ArrayList<BenhAn> xoaBenhAn(String id) {
        for (int i = 0; i < danhSachBenhAn.size(); i++) {
            if (danhSachBenhAn.get(i).getId().equals(id)) {
                danhSachBenhAn.remove(i);
                System.out.println("Đã xoá bệnh án.");
                break;
            }
        }
        return danhSachBenhAn;
    }

    public void inDanhSachBenhAn() {
        for (BenhAn ba : danhSachBenhAn) {
            System.out.println(ba.toString());
        }
    }
}
